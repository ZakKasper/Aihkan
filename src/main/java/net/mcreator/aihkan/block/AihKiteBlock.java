
package net.mcreator.aihkan.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.aihkan.itemgroup.AihkanItemsItemGroup;
import net.mcreator.aihkan.AihkanModElements;

@AihkanModElements.ModElement.Tag
public class AihKiteBlock extends AihkanModElements.ModElement {
	@ObjectHolder("aihkan:aih_kite")
	public static final Block block = null;
	public AihKiteBlock(AihkanModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AihkanItemsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("aih_kite");
		}
	}
}
