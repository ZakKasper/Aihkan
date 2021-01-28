
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class AihKiteGem2Item extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:aih_kite_gem_2")
	public static final Item block = null;

	public AihKiteGem2Item(AihkanModElements instance) {
		super(instance, 19);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AihkanItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("aih_kite_gem_2");
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
