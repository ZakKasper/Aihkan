
package net.mcreator.aihkan.block;

import net.minecraft.block.material.Material;

@AihkanModElements.ModElement.Tag
public class MagicTowerTrim1Block extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:magic_tower_trim_1")
	public static final Block block = null;

	public MagicTowerTrim1Block(AihkanModElements instance) {
		super(instance, 34);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AihkanItemsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 16f).lightValue(0).harvestLevel(4)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("magic_tower_trim_1");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
