package ca.volatilecobra77.sable_robotics.Graph.Nodes.Exec;

import ca.volatilecobra77.sable_robotics.Graph.GraphDataType;
import ca.volatilecobra77.sable_robotics.Graph.GraphExecutionContext;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports.DataPort;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports.ExecPort;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports.NodePort;
import ca.volatilecobra77.sable_robotics.Graph.RobotNode;
import net.minecraft.client.gui.GuiGraphics;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RobotNode(id = "sable_robotics:exec/debug_logger", name = "Debug Log Node", category = "debug", description = "Logs the value of 'Data' to console")
public class DebugLogNode extends BaseExecNode{
    public DebugLogNode(UUID id, double x, double y) {
        super(id, "debug_log", x, y);
        setPorts(new HashSet<>(Set.of(
                new ExecPort("Execute", this, true, 0),
                new DataPort(GraphDataType.STRING, "Data", this, true, 1)
        )));
    }
    public DebugLogNode() {
        this(UUID.randomUUID(), 0.0, 0.0);
    }

    @Override
    public boolean isStart() {
        return false;
    }

    @Override
    public void tick(GraphExecutionContext context) {
        System.out.println("DEBUG LOG NODE TICK, DATA " +((NodePort)this.ports.toArray()[1]).data(context));
    }

    @Override
    public Object evaluatePort(NodePort port, GraphExecutionContext context) {
        return null;
    }

    @Override
    public void render(GuiGraphics g) {

    }
}
