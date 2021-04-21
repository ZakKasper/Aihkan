
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class SihkumiteShovelItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:sihkumite_shovel")
	public static final Item block = null;

	public SihkumiteShovelItem(AihkanModElements instance) {
		super(instance, 70);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
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
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("sihkumite_shovel"));
	}

}
