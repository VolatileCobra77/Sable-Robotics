package ca.volatilecobra77.sable_robotics.Blocks.Entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class RobotControllerBe extends BlockEntity {
    public RobotControllerBe(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.ROBOT_CONTROLLER_BE.get(), pos, blockState);
    }
}
