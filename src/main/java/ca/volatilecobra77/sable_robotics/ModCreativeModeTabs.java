package ca.volatilecobra77.sable_robotics;

import ca.volatilecobra77.sable_robotics.Items.ModItems;
import net.mcexpanded.fancytabsections.FancyTabSections;
import net.mcexpanded.fancytabsections.Section.SectionColored;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


import static ca.volatilecobra77.sable_robotics.Items.ModItems.GARY;
import static ca.volatilecobra77.sable_robotics.Sable_robotics.rl;

public class ModCreativeModeTabs {


    public static final void regsiter(IEventBus modEventBus){
        FancyTabSections.registerCreativeModeTab(
                modEventBus, rl("sable_robotics"), () -> ModItems.ROBOT_CONTROLLER.get().getDefaultInstance()
        );
        FancyTabSections.registerCreativeModeTab(
                modEventBus, rl("gary"), ModItems.GARY
        );
    }
    public static final void registerTabSections(){
        FancyTabSections.addSection(rl("sable_robotics"),
                new SectionColored(rl("control_tab"))
                        .setTitle(Component.translatable("section.sable_robotics.control"))
                        .setBannerColor(0xFF1a1a2e)
                        .setTextColor(0xFFBBAA66)
                        .setTextShadow(true)
                        .add(ModItems.ROBOT_CONTROLLER)

        );
        FancyTabSections.addSection(rl("gary"),
                new SectionColored(rl("gary"))
                        .setTitle(Component.translatable("section.sable_robotics.gary"))
                        .setBannerColor(0xFFFFFFFF)
                        .setTextColor(0x000000FF)
                        .setTextShadow(true)
                        .add(ModItems.GARY));
    }
//    //this adds a solid coloured section to the CreativeModeTab registered under the ID "fancytabsections:dirty_tools"
//        FancyTabSections.addSection(rl("dirty_tools"),
//    //identifier of the section
//                new SectionColored(rl("very_dirty_tools"))
//            //title to display in the "empty row" (banner) of the section
//            //by default the title will use the translation key `section.[namespace].[path]`, just as shown here
//            .setTitle(Component.translatable("section.fancytabsections.very_dirty_tools"))
//            //background color of the "empty row" - ARGB
//            .setBannerColor(0xFF1a1a2e)
//    //text color - ARGB
//                        .setTextColor(0xFFBBAA66)
//    //text shadow
//                        .setTextShadow(true)
//
//    //adds an item
//                        .add(Items.BRUSH)
//    //adds a modded item, using the DeferredItem<Item>
//                        .add(FTSExampleModItems.MISSINGNO)
//    //adds an ItemStack
//                        .add(() ->
//    {
//        ItemStack exampleItemStack = Items.STONE_AXE.getDefaultInstance();
//        exampleItemStack.setDamageValue(20);
//        return exampleItemStack;
//    })
//            //adds a registry dependent item
//            .add((registry) ->
//    {
//        //in this example we use the registry to access the minecraft:pickaxes tag, and all items from it!
//        return registry.lookup(Registries.ITEM)
//                .map(lookup -> lookup.get(ItemTags.PICKAXES)
//                        .map(named -> named.stream()
//                                .map(holder -> holder.value().getDefaultInstance()).toList()
//                        ).orElse(List.of()))
//                .orElseGet(List::of);
//    })
//            );
//
//    //this adds a second section to our dirty_tools CreativeModeTab, this time using a texture for the banner
//        FancyTabSections.addSection(rl("dirty_tools"),
//    //when using the default texture location, it must be placed at [namespace]:textures/gui/fancy_tab_section/[path].png
//                new SectionTextured(rl("decently_dirty_tools"))
//            .setTextColor(0xFFFFFFFF)
//                        .setTextOutline(0xFF555500)
//                        .add(Items.IRON_SWORD)
//                        .add(Items.STONE_SHOVEL)
//                        .add(Items.STONE_HOE)
//        );

}
