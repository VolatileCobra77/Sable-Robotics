package ca.volatilecobra77.sable_robotics.Graph.Nodes;

import ca.volatilecobra77.sable_robotics.Graph.GraphNode;

import java.util.UUID;

public abstract class BaseExecNode extends GraphNode {
    public BaseExecNode(UUID id, String type, double x, double y) {
        super(id, type, x, y);
    }

    public abstract void startExec();
    public abstract void tick();
    public abstract void stopExec();
}
