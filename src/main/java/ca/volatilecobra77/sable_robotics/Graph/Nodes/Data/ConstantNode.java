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

@RobotNode(id = "sable_robotics:data/constant", name = "Constant", description = "A constant, unchanging value")
public class ConstantNode extends GraphNode {
    private Object value = 10f;
    private GraphDataType dataType = GraphDataType.FLOAT;
    public ConstantNode(UUID id,  double x, double y) {
        super(id, "constant", x, y);
        this.setPorts(new HashSet<>(Set.of(
                new DataPort(dataType, "value", this, false, 0)
        )));
    }
    public ConstantNode(){
        this(UUID.randomUUID(), 0.0, 0.0);
    }

    @Override
    public Object evaluatePort(NodePort port, GraphExecutionContext context) {
        if (this.getPorts().contains(port)) {
            return value;
        }
        return null;
    }

    @Override
    public void render(GuiGraphics g) {

    }
}
