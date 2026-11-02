package ca.volatilecobra77.sable_robotics.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GraphNode {
    private final UUID id;
    private final String type;
    private double x;
    private double y;
    private final Map<String, String> properties = new HashMap<>();

    public GraphNode(UUID id, String type, double x, double y){
        this.id = id;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public UUID getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setPosition(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Map<String, String> getProperties() {
        return properties;
    }
}
