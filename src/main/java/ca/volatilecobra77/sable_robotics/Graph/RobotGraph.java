package ca.volatilecobra77.sable_robotics.Graph;

import ca.volatilecobra77.sable_robotics.Blocks.Entities.RobotControllerBe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class RobotGraph {
    private final RobotControllerBe blockEntity;
    private HashMap<UUID, GraphNode> nodes = new HashMap<>();
    private List<GraphConnection> connections = new ArrayList<>();

    private List<UUID> startNodes;
    private boolean dirty;

    public RobotGraph(RobotControllerBe blockEntity) {
        this.blockEntity = blockEntity;
    }

    public void addNode(GraphNode node) {
        nodes.put(node.getId(), node);
        dirty = true;
    }
    public void removeNode(UUID nodeId) {
        nodes.remove(nodeId);
        connections.removeIf(connection -> connection.source().equals(nodeId) || connection.target().equals(nodeId));
        dirty = true;
    }
    /**
     * Finds the start of each tree, where the nodes end and if that node can start an execution tree, adds it's id to the startNodes
     * */
    public void FindStartNodes(){


        dirty = false;
    }

    /**Called once per interval, set by the graph update interval config
     *
     */
    public void execute(){
        if (dirty) return; //never operate on a dirty graph, only operate after the graph has been sorted to find the start nodes of each tree


    }

}
