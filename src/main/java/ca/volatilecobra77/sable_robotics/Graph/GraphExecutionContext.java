package ca.volatilecobra77.sable_robotics.Graph;

import ca.volatilecobra77.sable_robotics.Blocks.Entities.RobotControllerBe;
import ca.volatilecobra77.sable_robotics.Config;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Exec.BaseExecNode;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports.DataPort;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.GraphNode;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports.NodePort;

import java.util.*;

public class GraphExecutionContext {
    private final RobotControllerBe controller;
    private final int graphTick;
    private int execBudgetRemaining;
    private final Map<ConnectionLookup, GraphConnection> connections;
    private final Map<UUID, GraphNode> nodes;
    private final Map<NodePort, Object> cache = new HashMap<>();
    private final Set<NodePort> evaluating = new HashSet<>();

    public GraphExecutionContext(
            RobotControllerBe controller,
            int graphTick,
            Map<ConnectionLookup, GraphConnection> connections,
            Map<UUID, GraphNode> nodes
    ) {
        this.controller = controller;
        this.graphTick = graphTick;
        this.execBudgetRemaining = Config.graphExecBudget;
        this.connections = connections;
        this.nodes = nodes;
    }

    public RobotControllerBe getController() {
        return controller;
    }

    public int getGraphTick() {
        return graphTick;
    }

    public int getExecBudgetRemaining() {
        return execBudgetRemaining;
    }

    public Map<ConnectionLookup, GraphConnection> getConnections() {
        return connections;
    }

    public Map<UUID, GraphNode> getNodes() {
        return nodes;
    }

    public void consumeExecBudget(int amount) {
        if (amount < 0 || amount > execBudgetRemaining) {
            throw new IllegalArgumentException("Invalid execution budget consumption");
        }

        execBudgetRemaining -= amount;
    }
    public Object processPort(NodePort port) {
        if (cache.containsKey(port)) {
            return cache.get(port);
        }

        if (!evaluating.add(port)) {
            throw new IllegalStateException("Data cycle detected!");
        }

        try {
            // Input ports pull data from their connected source.
            if (port.input()) {
                GraphConnection conn = connections.entrySet().stream()
                        .filter(entry ->
                                entry.getKey().dest().equals(port.parentNode())
                        )
                        .map(Map.Entry::getValue)
                        .filter(connection -> connection.targetPort().id() == port.id())
                        .findFirst()
                        .orElse(null);

                return conn == null ? null : conn.sourcePort().data(this);
            }

            // Data output ports evaluate their parent node.
            if (port instanceof DataPort) {
                Object result = nodes.get(port.parentNode()).evaluatePort(port, this);

                if (result != null) {
                    cache.put(port, result);
                }

                return result;
            }

            // Execution output ports advance execution.
            if (nodes.get(port.parentNode()) instanceof BaseExecNode) {
                GraphConnection conn = connections.entrySet().stream()
                        .filter(entry ->
                                entry.getKey().source().equals(port.parentNode())
                        )
                        .map(Map.Entry::getValue)
                        .filter(connection -> connection.sourcePort().id() == port.id())
                        .findFirst()
                        .orElse(null);

                if (conn == null) {
                    return null;
                }

                if (!(nodes.get(conn.target()) instanceof BaseExecNode node)) {
                    throw new IllegalStateException(
                            "Execution connection targets an invalid node!"
                    );
                }

                node.tick(this);
                return null;
            }

            throw new IllegalStateException(
                    "Invalid port at " + controller.getBlockPos()
                            + ": " + port.name()
                            + " is not a DataPort and is not attached to a BaseExecNode"
            );

        } finally {
            evaluating.remove(port);
        }
    }
}