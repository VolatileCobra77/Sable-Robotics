package ca.volatilecobra77.sable_robotics.Items;

import ca.volatilecobra77.sable_robotics.Blocks.ModBlocks;
import ca.volatilecobra77.sable_robotics.Sable_robotics;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(Sable_robotics.MOD_ID);
    public static DeferredItem<Item> GARY = ITEMS.registerSimpleItem("gary", new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(1).saturationModifier(2f).build()));
    public static DeferredItem<BlockItem> ROBOT_CONTROLLER = ITEMS.registerSimpleBlockItem(ModBlocks.ROBOT_CONTROLLER, new Item.Properties());
}
