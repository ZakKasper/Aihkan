
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class CyborgArmDiamondItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:cyborg_arm_diamond")
	public static final Item block = null;

	public CyborgArmDiamondItem(AihkanModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3000;
			}

			public float getEfficiency() {
				return 10f;
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
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("cyborg_arm_diamond"));
	}

}
