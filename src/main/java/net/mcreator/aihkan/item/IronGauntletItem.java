
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class IronGauntletItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:iron_gauntlet")
	public static final Item block = null;

	public IronGauntletItem(AihkanModElements instance) {
		super(instance, 25);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AihkanItemsItemGroup.tab).maxStackSize(1).rarity(Rarity.UNCOMMON));
			setRegistryName("iron_gauntlet");
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
			return 450F;
		}

		@Override
		public boolean canHarvestBlock(BlockState state) {
			return true;
		}

	}

}
