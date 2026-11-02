package ca.volatilecobra77.sable_robotics.Screens;

import ca.volatilecobra77.sable_robotics.Menus.ModMenus;
import ca.volatilecobra77.sable_robotics.Sable_robotics;
import ca.volatilecobra77.sable_robotics.Screens.GraphEditor.RobotControllerScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(
        modid = Sable_robotics.MOD_ID,
        bus = EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(
                ModMenus.ROBOT_CONTROLLER.get(),
                RobotControllerScreen::new
        );
    }
}