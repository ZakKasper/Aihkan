
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class AihKiteToolsHoeItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:aih_kite_tools_hoe")
	public static final Item block = null;

	public AihKiteToolsHoeItem(AihkanModElements instance) {
		super(instance, 61);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1741;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 8;
			}

			public int getEnchantability() {
				return 56;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(FusedAihkiteItem.block, (int) (1)));
			}
		}, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("aih_kite_tools_hoe"));
	}

}
