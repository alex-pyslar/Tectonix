package ru.velesoft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TectonicGenerator {
    public static final Block TECTONIC_GENERATOR_BLOCK = new Block(Block.Settings.of(Material.METAL).strength(4.0f)) {
        @Override
        public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
            if (!world.isClient) {
                player.sendMessage(Text.of("Generating tectonic energy!"), false);
                player.getInventory().offerOrDrop(new ItemStack(Tectonix.TECTONIC_SHARD));
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        }
    };

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(Tectonix.MOD_ID, "tectonic_generator"), TECTONIC_GENERATOR_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Tectonix.MOD_ID, "tectonic_generator"), new BlockItem(TECTONIC_GENERATOR_BLOCK, new Item.Settings().group(ItemGroup.REDSTONE)));
    }
}