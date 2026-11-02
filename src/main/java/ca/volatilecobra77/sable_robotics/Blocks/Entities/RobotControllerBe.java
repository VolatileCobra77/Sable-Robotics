package ca.volatilecobra77.sable_robotics.Blocks.Entities;

import ca.volatilecobra77.sable_robotics.Graph.RobotGraph;
import ca.volatilecobra77.sable_robotics.Menus.RobotControllerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RobotControllerBe extends BlockEntity implements MenuProvider {
    private final RobotGraph graph;
    public RobotControllerBe(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.ROBOT_CONTROLLER_BE.get(), pos, blockState);
        this.graph = new RobotGraph(this);
    }
    @Override
    public Component getDisplayName() {
        return Component.translatable("block.sable_robotics.robot_controller");
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new RobotControllerMenu(containerId, inventory, this);
    }
}
