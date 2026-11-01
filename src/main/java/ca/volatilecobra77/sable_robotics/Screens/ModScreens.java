package ca.volatilecobra77.sable_robotics.Screens;

import ca.volatilecobra77.sable_robotics.Sable_robotics;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModScreens {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, Sable_robotics.MOD_ID);

    public static final Supplier<MenuType<RobotControllerMenu>> ROBOT_CONTROLLER = MENUS.register("robot_controller", ()-> IMenuTypeExtension.create(RobotControllerMenu::new));

    public static void register(IEventBus eventBus){
        MENUS.register(eventBus);
    }
}
