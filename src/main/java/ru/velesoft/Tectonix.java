package ru.velesoft;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class Tectonix implements ModInitializer {
    public static final String MOD_ID = "tectonix";

    // Тектоновый осколок
    public static final Item TECTONIC_SHARD = new Item(new Item.Settings().group(ItemGroup.MISC));
    // Ксенонитовый кристалл
    public static final Item XENONITE_CRYSTAL = new Item(new Item.Settings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "tectonic_shard"), TECTONIC_SHARD);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "xenonite_crystal"), XENONITE_CRYSTAL);
        TectonicOre.register();
        XenoniteOre.register();
        TectonicGenerator.register();
        TectonicDrill.register();
        XenoniteCutter.register();
        OreGeneration.register();
        System.out.println("Tectonix initialized!");
    }
}