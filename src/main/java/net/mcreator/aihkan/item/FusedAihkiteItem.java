
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class FusedAihkiteItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:fused_aihkite")
	public static final Item block = null;

	public FusedAihkiteItem(AihkanModElements instance) {
		super(instance, 20);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AihkanItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("fused_aihkite");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
