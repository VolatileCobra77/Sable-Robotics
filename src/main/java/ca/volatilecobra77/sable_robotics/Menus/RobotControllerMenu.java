package ca.volatilecobra77.sable_robotics.Menus;

import ca.volatilecobra77.sable_robotics.Blocks.Entities.RobotControllerBe;
import ca.volatilecobra77.sable_robotics.Blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;

public class RobotControllerMenu extends AbstractContainerMenu {

    private final ContainerLevelAccess access;
    private final BlockPos pos;

    // Server constructor
    public RobotControllerMenu(int containerId, Inventory inventory, RobotControllerBe blockEntity) {
        super(ModMenus.ROBOT_CONTROLLER.get(), containerId);

        this.pos = blockEntity.getBlockPos();
        this.access = ContainerLevelAccess.create(blockEntity.getLevel(), pos);
    }

    // Client constructor
    public RobotControllerMenu(int containerId, Inventory inventory, RegistryFriendlyByteBuf data) {
        super(ModMenus.ROBOT_CONTROLLER.get(), containerId);

        this.pos = data.readBlockPos();
        this.access = ContainerLevelAccess.create(inventory.player.level(), pos);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(access, player, ModBlocks.ROBOT_CONTROLLER.get());
    }
}