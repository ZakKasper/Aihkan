
package net.mcreator.aihkan.block;

import net.minecraft.block.material.Material;

@AihkanModElements.ModElement.Tag
public class PoisonLeavesBlock extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:poison_leaves")
	public static final Block block = null;

	public PoisonLeavesBlock(AihkanModElements instance) {
		super(instance, 48);

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

					Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(1f, 10f).lightValue(0));

			setRegistryName("poison_leaves");
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
