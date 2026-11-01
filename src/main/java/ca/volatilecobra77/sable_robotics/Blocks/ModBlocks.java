package ca.volatilecobra77.sable_robotics.Blocks;

import ca.volatilecobra77.sable_robotics.Sable_robotics;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Sable_robotics.MOD_ID);

    public static DeferredBlock<RobotController> ROBOT_CONTROLLER = BLOCKS.registerBlock("robot_controller", RobotController::new);

}
