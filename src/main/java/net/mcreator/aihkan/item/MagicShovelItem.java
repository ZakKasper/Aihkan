
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class MagicShovelItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:magic_shovel")
	public static final Item block = null;

	public MagicShovelItem(AihkanModElements instance) {
		super(instance, 124);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 145;
			}

			public float getEfficiency() {
				return 5f;
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
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("magic_shovel"));
	}

}
