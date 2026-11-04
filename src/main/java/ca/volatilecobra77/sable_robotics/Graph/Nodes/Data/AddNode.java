package ca.volatilecobra77.sable_robotics.Graph.Nodes.Data;

import ca.volatilecobra77.sable_robotics.Graph.NodePort;

import java.util.HashSet;
import java.util.UUID;

public class AddNode extends BaseDataNode{
    public AddNode(UUID id, String type, double x, double y, HashSet<NodePort> ports) {
        super(id, type, x, y, ports);
    }
}
