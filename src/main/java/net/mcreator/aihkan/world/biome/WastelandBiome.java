
package net.mcreator.aihkan.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;

import net.mcreator.aihkan.block.WastelandDirtBlock;
import net.mcreator.aihkan.block.DeadGrassBlock;
import net.mcreator.aihkan.AihkanModElements;

@AihkanModElements.ModElement.Tag
public class WastelandBiome extends AihkanModElements.ModElement {
	@ObjectHolder("aihkan:wasteland")
	public static final CustomBiome biome = null;
	public WastelandBiome(AihkanModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.DEAD);
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0.1f).scale(0.1f).temperature(1.6f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.SAVANNA).waterColor(4159204).waterFogColor(329011).parent("aihkan:magic_forest")
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(DeadGrassBlock.block.getDefaultState(),
							WastelandDirtBlock.block.getDefaultState(), WastelandDirtBlock.block.getDefaultState())));
			setRegistryName("wasteland");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addStructures(this);
		}
	}
}
