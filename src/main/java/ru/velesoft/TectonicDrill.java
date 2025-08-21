package ru.velesoft;

import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class TectonicDrill {
    public static final PickaxeItem TECTONIC_DRILL = new PickaxeItem(ToolMaterials.DIAMOND, 1, -2.8f, new Item.Settings().group(ItemGroup.TOOLS)) {
        @Override
        public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
            float multiplier = super.getMiningSpeedMultiplier(stack, state);
            if (getHolder() != null && getHolder().getWorld().getBiome(getHolder().getBlockPos()).getCategory() == net.minecraft.world.biome.Biome.Category.MOUNTAINS) {
                multiplier *= 1.5f; // Faster in mountains
            }
            return multiplier;
        }
    };

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(Tectonix.MOD_ID, "tectonic_drill"), TECTONIC_DRILL);
    }
}