package ca.volatilecobra77.sable_robotics.Blocks.Entities;

import ca.volatilecobra77.sable_robotics.Blocks.ModBlocks;
import ca.volatilecobra77.sable_robotics.Sable_robotics;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {

    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Sable_robotics.MOD_ID);

    public static Supplier<BlockEntityType<RobotControllerBe>> ROBOT_CONTROLLER_BE = BLOCK_ENTITIES.register("robot_controller", ()->
        BlockEntityType.Builder.of(RobotControllerBe::new, ModBlocks.ROBOT_CONTROLLER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}

