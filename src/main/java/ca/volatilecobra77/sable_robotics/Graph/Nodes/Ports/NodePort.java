package ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports;

import ca.volatilecobra77.sable_robotics.Graph.GraphDataType;
import ca.volatilecobra77.sable_robotics.Graph.GraphExecutionContext;

import java.util.UUID;

public abstract class NodePort {
    private final GraphDataType type;
    private final String name;
    private final UUID parentNode;
    protected final boolean input;
    private final int id;
    public NodePort(
            GraphDataType type,
            String name,
            UUID parentNode,
            boolean input,
            int id) {
        this.type = type;
        this.name = name;
        this.parentNode = parentNode;
        this.input = input;
        this.id = id;
    }

    public GraphDataType type() {
        return type;
    }

    public String name() {
        return name;
    }

    public UUID parentNode() {
        return parentNode;
    }

    public boolean input() {
        return input;
    }

    public int id() {
        return id;
    }

    public abstract Object data(GraphExecutionContext context);
}