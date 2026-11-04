package ca.volatilecobra77.sable_robotics.Graph.Nodes.Exec;

import ca.volatilecobra77.sable_robotics.Graph.GraphDataType;
import ca.volatilecobra77.sable_robotics.Graph.GraphExecutionContext;
import ca.volatilecobra77.sable_robotics.Graph.NodePort;
import ca.volatilecobra77.sable_robotics.Graph.RobotNode;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RobotNode(id = "sable_robotics:exec/debug_logger", name = "Debug Log Node", category = "debug", description = "Logs the value of 'Data' to console")
public class DebugLogNode extends BaseExecNode{
    public DebugLogNode(UUID id, double x, double y) {
        super(id, "debug_log", x, y, new HashSet<>(Set.of(
                new NodePort(GraphDataType.EXEC, "Execute", id, true, 0, null),
                new NodePort(GraphDataType.STRING, "Data", id, true, 1, null)
        )));
    }

    @Override
    public boolean isStart() {
        return false;
    }

    @Override
    public void tick(GraphExecutionContext context) {
        System.out.println("DEBUG LOG NODE TICK, DATA " +((NodePort)this.ports.toArray()[1]).data());
    }

    @Override
    public void render(GuiGraphics g) {

    }
}
