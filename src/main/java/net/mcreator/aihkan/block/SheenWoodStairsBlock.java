
package net.mcreator.aihkan.block;

import net.minecraft.block.material.Material;

@AihkanModElements.ModElement.Tag
public class SheenWoodStairsBlock extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:sheen_wood_stairs")
	public static final Block block = null;

	public SheenWoodStairsBlock(AihkanModElements instance) {
		super(instance, 101);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AihkanItemsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends StairsBlock {

		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3f, 2f)).getDefaultState(),

					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3f, 2f).lightValue(0));

			setRegistryName("sheen_wood_stairs");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 5;
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
