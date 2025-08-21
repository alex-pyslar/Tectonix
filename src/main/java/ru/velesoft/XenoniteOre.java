package ru.velesoft;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class XenoniteOre {
    public static final Block XENONITE_ORE_BLOCK = new Block(Block.Settings.of(Material.STONE).strength(4.0f, 4.0f));

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(Tectonix.MOD_ID, "xenonite_ore"), XENONITE_ORE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Tectonix.MOD_ID, "xenonite_ore"), new BlockItem(XENONITE_ORE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }
}