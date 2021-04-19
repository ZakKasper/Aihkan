
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class SihkumiteHoeItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:sihkumite_hoe")
	public static final Item block = null;

	public SihkumiteHoeItem(AihkanModElements instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 660;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SihkumiteIngotItem.block, (int) (1)));
			}
		}, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("sihkumite_hoe"));
	}

}
