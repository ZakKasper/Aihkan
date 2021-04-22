
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class SnakevenomitemItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:snakevenomitem")
	public static final Item block = null;

	public SnakevenomitemItem(AihkanModElements instance) {
		super(instance, 117);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(16).rarity(Rarity.COMMON));
			setRegistryName("snakevenomitem");
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
