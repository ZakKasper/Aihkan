
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class MagicHoeItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:magic_hoe")
	public static final Item block = null;

	public MagicHoeItem(AihkanModElements instance) {
		super(instance, 125);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 145;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(MagicWoodPlanksBlock.block, (int) (1)));
			}
		}, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("magic_hoe"));
	}

}
