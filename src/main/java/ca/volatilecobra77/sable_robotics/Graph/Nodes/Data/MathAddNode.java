package ca.volatilecobra77.sable_robotics.Graph.Nodes.Data;

import ca.volatilecobra77.sable_robotics.Graph.GraphDataType;
import ca.volatilecobra77.sable_robotics.Graph.GraphExecutionContext;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.GraphNode;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports.DataPort;
import ca.volatilecobra77.sable_robotics.Graph.Nodes.Ports.NodePort;
import ca.volatilecobra77.sable_robotics.Graph.RobotNode;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RobotNode(id="sable_robotics:data/math_add", name="Add", category = "math", description = "Adds the value of A and B together")
public class MathAddNode extends GraphNode {
    public MathAddNode(UUID id, double x, double y) {
        super(id, "mathAdd", x, y);
        this.setPorts(new HashSet<>(Set.of(
                new DataPort(GraphDataType.FLOAT, "output", this, false, 0), //the output port
                new DataPort(GraphDataType.FLOAT, "a", this, true, 1), // first number
                new DataPort(GraphDataType.FLOAT, "b", this, true, 2) //second number
        )));
    }

    public MathAddNode(){
        super("mathAdd");
    }

    @Override
    public Object evaluatePort(NodePort port, GraphExecutionContext context) {
        if (this.getPorts().contains(port) && !port.input()) {
            DataPort aPort = (DataPort) this.getPort(1);
            DataPort bPort = (DataPort) this.getPort(2);
            if (aPort.data(context) instanceof Float a && bPort.data(context) instanceof Float b) {
                return a+b;
            }else{
                throw new RuntimeException("Add node did not recive floats from its port evaluation, what happened??");
            }
        }
        return null;
    }

    @Override
    public void render(GuiGraphics g) {

    }
}
