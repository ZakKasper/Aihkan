
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class LeatherGauntletItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:leather_gauntlet")
	public static final Item block = null;

	public LeatherGauntletItem(AihkanModElements instance) {
		super(instance, 24);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AihkanItemsItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("leather_gauntlet");
		}

		@Override
		public int getItemEnchantability() {
			return 9;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 100F;
		}

		@Override
		public boolean canHarvestBlock(BlockState state) {
			return true;
		}

	}

}
