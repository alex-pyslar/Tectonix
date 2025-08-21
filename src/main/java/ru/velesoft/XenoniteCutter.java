package ru.velesoft;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class XenoniteCutter {
    public static final SwordItem XENONITE_CUTTER = new SwordItem(ToolMaterials.NETHERITE, 3, -2.4f, new Item.Settings().group(ItemGroup.COMBAT)) {
        @Override
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            if (target.getType() == EntityType.ENDERMAN || target.getType() == EntityType.ENDER_DRAGON) {
                target.damage(target.getDamageSources().generic(), 4.0f); // Extra damage to End mobs
                if (attacker.getWorld().getRandom().nextFloat() < 0.2f) { // 20% chance to drop Xenonite Crystal
                    target.dropStack(new ItemStack(Tectonix.XENONITE_CRYSTAL));
                }
            }
            return super.postHit(stack, target, attacker);
        }
    };

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(Tectonix.MOD_ID, "xenonite_cutter"), XENONITE_CUTTER);
    }
}