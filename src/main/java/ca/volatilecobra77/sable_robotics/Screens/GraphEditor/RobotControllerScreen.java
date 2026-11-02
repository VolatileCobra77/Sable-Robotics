package ca.volatilecobra77.sable_robotics.Screens.GraphEditor;

import ca.volatilecobra77.sable_robotics.Menus.RobotControllerMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class RobotControllerScreen extends AbstractContainerScreen<RobotControllerMenu> {
    private final GraphCanvas canvas;
    private final NodePalette palette;
    private final NodePropertiesPanel propertiesPanel;
    private final GraphToolbar toolbar;

    public RobotControllerScreen(
            RobotControllerMenu menu,
            Inventory inventory,
            Component title
    ) {
        super(menu, inventory, title);

//        this.imageWidth = 256;
//        this.imageHeight = 180;
        this.canvas = new GraphCanvas();
        this.palette = new NodePalette();
        this.propertiesPanel = new NodePropertiesPanel();
        this.toolbar = new GraphToolbar();
    }

    @Override
    protected void renderBg(
            GuiGraphics graphics,
            float partialTick,
            int mouseX,
            int mouseY
    ) {
//        int x = (width - imageWidth) / 2;
//        int y = (height - imageHeight) / 2;

        // Temporary GUI background
        canvas.draw(this,graphics, mouseX, mouseY, partialTick);
        palette.draw(this,graphics, mouseX, mouseY, partialTick);
        propertiesPanel.draw(this, graphics, mouseX, mouseY, partialTick);
        toolbar.draw(this, graphics, mouseX, mouseY, partialTick);
    }

    @Override
    protected void renderLabels(
            GuiGraphics graphics,
            int mouseX,
            int mouseY
    ) {
        graphics.drawString(font, title, 10, 10, 0xFFFFFF);
    }
}