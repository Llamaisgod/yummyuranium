package com.example.uraniumsnack;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

@Mod(UraniumSnack.MODID)
public class UraniumSnack {
    public static final String MODID = "uraniumsnack";

    public UraniumSnack(IEventBus modEventBus) {
        modEventBus.addListener(UraniumSnack::modifyComponents);
    }

    private static void modifyComponents(ModifyDefaultComponentsEvent event) {
        // Raw steak: 3 nutrition, saturation modifier 0.3 (= 1.8 saturation)
        makeEdible(event, "raw_uranium", 3, 0.3f);

        // Cooked steak is 8 nutrition / 0.8 modifier (= 12.8 saturation).
        // Double that: 16 nutrition, same 0.8 modifier (= 25.6 saturation).
        makeEdible(event, "ingot_uranium", 16, 0.8f);
    }

    private static void makeEdible(ModifyDefaultComponentsEvent event, String path, int nutrition, float saturationModifier) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("mekanism", path);
        if (!BuiltInRegistries.ITEM.containsKey(id)) {
            return; // Mekanism item not found, skip quietly
        }
        Item item = BuiltInRegistries.ITEM.get(id);
        FoodProperties food = new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturationModifier)
                .alwaysEdible()
                .build();
        event.modify(item, builder -> builder.set(DataComponents.FOOD, food));
    }
}
