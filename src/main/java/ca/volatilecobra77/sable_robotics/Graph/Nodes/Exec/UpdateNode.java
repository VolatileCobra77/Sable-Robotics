package ca.volatilecobra77.sable_robotics.Graph.Nodes.Exec;

import ca.volatilecobra77.sable_robotics.Graph.GraphDataType;
import ca.volatilecobra77.sable_robotics.Graph.GraphExecutionContext;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports.ExecPort;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports.NodePort;
import ca.volatilecobra77.sable_robotics.Graph.RobotNode;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RobotNode(id = "sable_robotics:exec/update", name="update", category = "exec_flow", description = "Fires Update pin once per graph tick")
public class UpdateNode extends BaseExecNode {
    public UpdateNode(UUID id, double x, double y) {
        super(id, "update", x, y);
        setPorts(new HashSet<>(Set.of(
                new ExecPort( "Update", this, false, 0)
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
        this.ports.stream().findFirst().ifPresent(port->{
           if (port instanceof ExecPort exec) {
               exec.setActive();
               exec.data(context);
           }
        });
    }

    @Override
    public Object evaluatePort(NodePort port, GraphExecutionContext context) {
        return null; //no input ports to evaluate
    }

    @Override
    public void render(GuiGraphics g) {

    }
}
