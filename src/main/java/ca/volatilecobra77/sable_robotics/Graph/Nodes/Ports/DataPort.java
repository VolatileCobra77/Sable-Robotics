package ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports;

import ca.volatilecobra77.sable_robotics.Graph.GraphDataType;
import ca.volatilecobra77.sable_robotics.Graph.GraphExecutionContext;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.GraphNode;

public class DataPort extends NodePort {
    public DataPort(GraphDataType type, String name, GraphNode parentNode, boolean input, int id) {
        super(type, name, parentNode.getId(), input, id);
    }

    @Override
    public Object data(GraphExecutionContext context) {
        return context.processPort(this);
    }
}
