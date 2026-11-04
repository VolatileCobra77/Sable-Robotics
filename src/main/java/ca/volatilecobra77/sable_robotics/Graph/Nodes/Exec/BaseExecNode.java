package ca.volatilecobra77.sable_robotics.Graph.Nodes.Exec;

import ca.volatilecobra77.sable_robotics.Graph.GraphExecutionContext;
import ca.volatilecobra77.sable_robotics.Graph.NodePort;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.GraphNode;

import java.util.HashSet;
import java.util.UUID;

public abstract class BaseExecNode extends GraphNode {
    public BaseExecNode(UUID id, String type, double x, double y, HashSet<NodePort> ports) {
        super(id, type, x, y,  new HashSet<>(){});
    }
    /**This value is for the nodes that contain no inputs and should start an execution flow, such as an Update, Interval or Keypress. This is NOT for sensor reading or actuators.
     * */
    public abstract boolean isStart();
    public abstract void tick(GraphExecutionContext context);
}
