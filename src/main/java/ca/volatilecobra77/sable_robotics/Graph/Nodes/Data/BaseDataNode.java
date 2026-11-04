package ca.volatilecobra77.sable_robotics.Graph.Nodes.Data;

import ca.volatilecobra77.sable_robotics.Graph.GraphConnection;
import ca.volatilecobra77.sable_robotics.Graph.NodePort;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.GraphNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public abstract class BaseDataNode extends GraphNode {
    private final HashMap<NodePort, GraphConnection> connections;
    public BaseDataNode(UUID id, String type, double x, double y, HashSet<NodePort> ports) {
        super(id, type, x, y, ports);
        this.connections = new HashMap<>();
    }
    public abstract Object run();
    @Override
    public void onConnect(GraphConnection connection, NodePort connectedPort) {
        connections.put(connectedPort, connection);
    }

    @Override
    public void onDisconnect(GraphConnection connection, NodePort connectedPort) {
        connections.remove(connectedPort);
    }
}
