
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class MagicAxeItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:magic_axe")
	public static final Item block = null;

	public MagicAxeItem(AihkanModElements instance) {
		super(instance, 122);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 150;
			}

			public float getEfficiency() {
				return 5f;
			}

			public float getAttackDamage() {
				return 5.5f;
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
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("magic_axe"));
	}

}
