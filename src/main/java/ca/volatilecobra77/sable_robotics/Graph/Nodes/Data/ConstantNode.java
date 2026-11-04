package ca.volatilecobra77.sable_robotics.Graph.Nodes.Data;

import ca.volatilecobra77.sable_robotics.Graph.NodePort;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashSet;
import java.util.UUID;

public class ConstantNode extends BaseDataNode{
    public ConstantNode(UUID id, String type, double x, double y, HashSet<NodePort> ports) {
        super(id, type, x, y, ports);
    }

    @Override
    public void render(GuiGraphics g) {

    }
}
