
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class CyborgArmStoneItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:cyborg_arm_stone")
	public static final Item block = null;

	public CyborgArmStoneItem(AihkanModElements instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 393;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(AihkanItemsItemGroup.tab)) {

		}.setRegistryName("cyborg_arm_stone"));
	}

}
