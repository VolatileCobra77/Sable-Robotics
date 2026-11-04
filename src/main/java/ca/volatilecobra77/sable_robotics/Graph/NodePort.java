package ca.volatilecobra77.sable_robotics.Graph;

import java.util.UUID;

public class NodePort {
    private final GraphDataType type;
    private final String name;
    private final UUID parentNode;
    protected final boolean input;
    private final int id;
    protected Object data;

    public NodePort(
            GraphDataType type,
            String name,
            UUID parentNode,
            boolean input,
            int id,
            Object data
    ) {
        this.type = type;
        this.name = name;
        this.parentNode = parentNode;
        this.input = input;
        this.id = id;
        this.data = data;
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

    public Object data() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}