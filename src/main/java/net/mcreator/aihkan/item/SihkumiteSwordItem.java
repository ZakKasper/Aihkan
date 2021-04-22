
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class SihkumiteSwordItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:sihkumite_sword")
	public static final Item block = null;

	public SihkumiteSwordItem(AihkanModElements instance) {
		super(instance, 69);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
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
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("sihkumite_sword"));
	}

}
