
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class DropTihttriumItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:drop_tihttrium")
	public static final Item block = null;

	public DropTihttriumItem(AihkanModElements instance) {
		super(instance, 11);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("drop_tihttrium");
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
