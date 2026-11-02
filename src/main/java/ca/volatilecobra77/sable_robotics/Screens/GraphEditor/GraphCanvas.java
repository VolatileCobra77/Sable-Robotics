package ca.volatilecobra77.sable_robotics.Screens.GraphEditor;

import net.minecraft.client.gui.GuiGraphics;

public class GraphCanvas {
    public static int BG_COLOR = 0;
    public void draw(RobotControllerScreen robotControllerScreen, GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        graphics.fill(0, 0, robotControllerScreen.width, robotControllerScreen.height,BG_COLOR); //background
        //draw each node
    }
}
