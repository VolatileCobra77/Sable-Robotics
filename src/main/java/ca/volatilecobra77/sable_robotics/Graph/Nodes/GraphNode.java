package ca.volatilecobra77.sable_robotics.Graph.Nodes;

import ca.volatilecobra77.sable_robotics.Graph.GraphConnection;
import ca.volatilecobra77.sable_robotics.Graph.GraphExecutionContext;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports.NodePort;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public abstract class GraphNode {
    private final UUID id;
    private final String type;
    private double x;
    private double y;
    protected final HashSet<NodePort> ports = new HashSet<>();
    private final HashMap<NodePort, GraphConnection> connections;


    public GraphNode(UUID id, String type, double x, double y){
        this.id = id;
        this.type = type;
        this.x = x;
        this.y = y;
        this.connections = new HashMap<>();

    }
    public void setPorts(HashSet<NodePort> ports){
        if (this.ports.isEmpty()) this.ports.addAll(ports); //only set ports once, dont re-set them if called again
    }
    public GraphNode(String type){
        this.id = UUID.randomUUID();
        this.type = type;
        this.x = 0;
        this.y = 0;
        this.connections = new HashMap<>();
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
    public void onConnect(GraphConnection connection, NodePort connectedPort) {
        connections.put(connectedPort, connection);
    }
    public void onDisconnect(GraphConnection connection, NodePort connectedPort) {
        connections.remove(connectedPort);
    }
    public abstract Object evaluatePort(NodePort port, GraphExecutionContext context);


    public HashSet<NodePort> getPorts(){
        return ports;
    };
    public abstract void render(GuiGraphics g);
    public NodePort getPort(int id){
        for (NodePort port : ports) {
            if (port.id() == id) return port;
        }
        throw new RuntimeException("No such port with id " + id);
    }
    //public abstract void render(GuiGraphics graphics, float partialTick);
}
