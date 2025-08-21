package ru.velesoft;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public class OreGeneration {
    public static void register() {
        // Тектоновая руда
        ConfiguredFeature<?, ?> tectonicOreFeature = new ConfiguredFeature<>(
                Feature.ORE,
                new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, TectonicOre.TECTONIC_ORE_BLOCK.getDefaultState(), 9)
        );

        PlacedFeature tectonicOrePlaced = new PlacedFeature(
                RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Tectonix.MOD_ID, "tectonic_ore")),
                java.util.List.of(
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(-16)),
                        CountPlacementModifier.of(20)
                )
        );

        Registry.register(Registry.CONFIGURED_FEATURE, new Identifier(Tectonix.MOD_ID, "tectonic_ore"), tectonicOreFeature);
        Registry.register(Registry.PLACED_FEATURE, new Identifier(Tectonix.MOD_ID, "tectonic_ore"), tectonicOrePlaced);

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Tectonix.MOD_ID, "tectonic_ore"))
        );

        // Ксенонитовая руда
        ConfiguredFeature<?, ?> xenoniteOreFeature = new ConfiguredFeature<>(
                Feature.ORE,
                new OreFeatureConfig(OreFeatureConfig.Rules.END_STONE, XenoniteOre.XENONITE_ORE_BLOCK.getDefaultState(), 4)
        );

        PlacedFeature xenoniteOrePlaced = new PlacedFeature(
                RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Tectonix.MOD_ID, "xenonite_ore")),
                java.util.List.of(
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(128)),
                        CountPlacementModifier.of(10)
                )
        );

        Registry.register(Registry.CONFIGURED_FEATURE, new Identifier(Tectonix.MOD_ID, "xenonite_ore"), xenoniteOreFeature);
        Registry.register(Registry.PLACED_FEATURE, new Identifier(Tectonix.MOD_ID, "xenonite_ore"), xenoniteOrePlaced);

        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Tectonix.MOD_ID, "xenonite_ore"))
        );
    }
}