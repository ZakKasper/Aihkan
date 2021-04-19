
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class MagicPickaxeItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:magic_pickaxe")
	public static final Item block = null;

	public MagicPickaxeItem(AihkanModElements instance) {
		super(instance, 121);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 155;
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

		}.setRegistryName("magic_pickaxe"));
	}

}
