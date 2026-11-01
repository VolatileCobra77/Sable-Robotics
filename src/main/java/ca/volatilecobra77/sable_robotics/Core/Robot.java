package ca.volatilecobra77.sable_robotics.Core;

import ca.volatilecobra77.sable_robotics.Blocks.Entities.RobotControllerBe;
import ca.volatilecobra77.sable_robotics.Core.Components.IComponent;
import dev.ryanhcode.sable.companion.SableCompanion;
import dev.ryanhcode.sable.companion.SubLevelAccess;
import dev.ryanhcode.sable.sublevel.SubLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Robot {
    private UUID sublevel_id;
    private SubLevel sublevel;
    private Map<UUID, IComponent> components;
    private RobotControllerBe controller;

    public Robot(SubLevel sublevel, RobotControllerBe controller) {
        this.sublevel = sublevel;
        this.sublevel_id = sublevel.getUniqueId();
        this.components = new HashMap<>();
    }
    public UUID getSublevel_id() {
        return sublevel_id;
    }
    public SubLevel getSublevel() {
        return sublevel;
    }
    public Level getLevel(){
        return sublevel.getLevel();
    }
    public Map<UUID, IComponent> getComponents() {
        return components;
    }
    public IComponent getComponent(UUID component_id){
        return components.get(component_id);
    }
    public Position getWorldSpacePosition(){
        return SableCompanion.INSTANCE.projectOutOfSubLevel(getLevel(), (Position) controller.getBlockPos());
    }
}
