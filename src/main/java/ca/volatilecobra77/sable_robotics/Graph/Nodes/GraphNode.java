package ca.volatilecobra77.sable_robotics.Graph.Nodes;

import ca.volatilecobra77.sable_robotics.Graph.GraphConnection;
import ca.volatilecobra77.sable_robotics.Graph.NodePort;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

public abstract class GraphNode {
    private final UUID id;
    private final String type;
    private double x;
    private double y;
    protected final HashSet<NodePort> ports = new HashSet<>();


    public GraphNode(UUID id, String type, double x, double y, HashSet<NodePort> ports){
        this.id = id;
        this.type = type;
        this.x = x;
        this.y = y;
        this.ports.addAll(ports);
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
    public void onConnect(GraphConnection connection, NodePort connectedPort){}
    public void onDisconnect(GraphConnection connection, NodePort connectedPort){}

    public HashSet<NodePort> getPorts(){
        return ports;
    };
    public abstract void render(GuiGraphics g);

    //public abstract void render(GuiGraphics graphics, float partialTick);
}
