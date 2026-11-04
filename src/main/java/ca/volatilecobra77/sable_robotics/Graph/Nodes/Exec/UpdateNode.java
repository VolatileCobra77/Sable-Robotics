package ca.volatilecobra77.sable_robotics.Graph.Nodes.Exec;

import ca.volatilecobra77.sable_robotics.Config;
import ca.volatilecobra77.sable_robotics.Graph.GraphDataType;
import ca.volatilecobra77.sable_robotics.Graph.GraphExecutionContext;
import ca.volatilecobra77.sable_robotics.Graph.NodePort;
import ca.volatilecobra77.sable_robotics.Graph.RobotNode;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RobotNode(id = "sable_robotics:exec/update", name="update", category = "exec_flow", description = "Fires Update pin once per graph tick")
public class UpdateNode extends BaseExecNode {
    public UpdateNode(UUID id, double x, double y) {
        super(id, "update", x, y, new HashSet<>(Set.of(
                new NodePort(GraphDataType.EXEC, "Update", id, false, 0,null)
        )));
    }
    public UpdateNode(){
        this(UUID.randomUUID(), 0.0, 0.0);
    }

    @Override
    public boolean isStart() {
        return true;
    }

    @Override
    public void tick(GraphExecutionContext context) {

    }

    @Override
    public void render(GuiGraphics g) {

    }
}
