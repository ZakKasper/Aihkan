
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class CyborgArmIronItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:cyborg_arm_iron")
	public static final Item block = null;

	public CyborgArmIronItem(AihkanModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 750;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(AihkanItemsItemGroup.tab)) {

		}.setRegistryName("cyborg_arm_iron"));
	}

}
