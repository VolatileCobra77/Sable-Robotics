package ca.volatilecobra77.sable_robotics.Graph;

import ca.volatilecobra77.sable_robotics.Blocks.Entities.RobotControllerBe;
import ca.volatilecobra77.sable_robotics.Config;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Exec.BaseExecNode;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.GraphNode;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports.NodePort;

import java.util.*;
import java.util.logging.Logger;

public class RobotGraph {
    private final RobotControllerBe blockEntity;
    private Map<UUID, GraphNode> nodes = new HashMap<>();
    private Map<ConnectionLookup, GraphConnection> connections = new HashMap<>(); //Connections ordered by which ones originate from a specific node (uuid)
    private Logger LOGGER = Logger.getLogger(RobotGraph.class.getName());
    private List<UUID> startNodes;
    private boolean dirty;
    private int graphTick;
    public RobotGraph(RobotControllerBe blockEntity) {
        this.blockEntity = blockEntity;
    }
    public void addNode(GraphNode node) {
        nodes.put(node.getId(), node);
        dirty = true;
    }
    public NodeConnectResult connect(UUID originNode, NodePort originPort, UUID destNode, NodePort destPort) {
        if (originNode.equals(destNode)) return NodeConnectResult.DeniedSameNode;
        if (originPort.type() != destPort.type()) return NodeConnectResult.InvalidType;
        if (originPort.input() && destPort.input()) return NodeConnectResult.TwoInputs;
        if (!originPort.input() && !destPort.input()) return NodeConnectResult.TwoOutputs;
        connections.put(new ConnectionLookup(originNode, destNode), new GraphConnection(originNode, originPort,destNode, destPort, originPort.type()));
        return NodeConnectResult.Success;
    }
    public enum NodeConnectResult{
        InvalidType,
        DeniedSameNode,
        TwoInputs,
        TwoOutputs,
        Aborted,
        Success
    }
    public void removeNode(UUID nodeId) {
        nodes.remove(nodeId);
        List<ConnectionLookup> toRemove = new ArrayList<>();
        connections.forEach((ID,connection) -> {
            if (connection.source().equals(nodeId) || connection.target().equals(nodeId)) toRemove.add(ID);
        });
        for (ConnectionLookup id : toRemove) {
            connections.remove(id);
        }
        dirty = true;
    }
    /**
     * Finds the start of each tree, where the nodes end and if that node can start an execution tree, adds it's id to the startNodes
     * */
    public void FindStartNodes(){
        startNodes = nodes.entrySet().stream()
                .filter(entry -> {
                    if (entry.getValue() instanceof BaseExecNode execNode){
                        return execNode.isStart();
                    }
                    return false;
                })
                .map(Map.Entry::getKey)
                .toList();
        dirty = false;
    }
    /**Called once per interval, set by the graph update interval config
     *  will not execute if the graph is dirty, FindStartNodes must be called before, when the graph editor closes or when a save event is triggered
     */

    public void resetGraphTick(){
        graphTick = 0;
    }
    public void execute(){
        if (dirty) {
            LOGGER.warning("Attempting to operate on dirty graph at " + blockEntity.getBlockPos() + " something is not right, FindStartNodes was not executed for some reason");
        }; //never operate on a dirty graph, only operate after the graph has been sorted to find the start nodes of each tree
        graphTick ++;
        GraphExecutionContext context = new GraphExecutionContext(blockEntity,graphTick, connections,nodes);
        Queue<BaseExecNode> queue = new LinkedList<>();
        queue.addAll(getExecNodes());
        int execBudget = Config.graphExecBudget;
        while(!queue.isEmpty() && execBudget-- > 0){
            BaseExecNode node = queue.poll();
            node.tick(context); //this calls the WHOLE tree from that baseExecNode
        }
        if (!queue.isEmpty()) {
            LOGGER.warning("Exec budget exhausted for graph at " + blockEntity.getBlockPos() + " either increase GraphExecBudget config or decrease the number of exec nodes in the graph");
        }
    }
    List<BaseExecNode> getExecNodes(){
        List<BaseExecNode> execNodes = new ArrayList<>();
        for (UUID nodeId : nodes.keySet()) {
            GraphNode node = nodes.get(nodeId);
            if (node instanceof BaseExecNode execNode){
                execNodes.add(execNode);
            }
        }
        return execNodes;
    }
}
