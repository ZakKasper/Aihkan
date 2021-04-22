
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class MagicSwordItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:magic_sword")
	public static final Item block = null;

	public MagicSwordItem(AihkanModElements instance) {
		super(instance, 123);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 160;
			}

			public float getEfficiency() {
				return 5f;
			}

			public float getAttackDamage() {
				return 4.5f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(MagicWoodPlanksBlock.block, (int) (1)));
			}
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("magic_sword"));
	}

}
