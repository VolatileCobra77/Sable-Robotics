package ca.volatilecobra77.sable_robotics.Graph;

import ca.volatilecobra77.sable_robotics.Blocks.Entities.RobotControllerBe;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.GraphNode;

import java.sql.Connection;
import java.util.Map;
import java.util.UUID;

package ca.volatilecobra77.sable_robotics.Graph;

import ca.volatilecobra77.sable_robotics.Blocks.Entities.RobotControllerBe;

import java.util.Map;
import java.util.UUID;

public class GraphExecutionContext {
    private final RobotControllerBe controller;
    private final int graphTick;
    private int execBudgetRemaining;
    private final Map<ConnectionLookup, Connection> connections;
    private final Map<UUID, GraphNode> nodes;

    public GraphExecutionContext(
            RobotControllerBe controller,
            int graphTick,
            int execBudgetRemaining,
            Map<ConnectionLookup, Connection> connections,
            Map<UUID, GraphNode> nodes
    ) {
        this.controller = controller;
        this.graphTick = graphTick;
        this.execBudgetRemaining = execBudgetRemaining;
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

    public Map<ConnectionLookup, Connection> getConnections() {
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
    public void
}