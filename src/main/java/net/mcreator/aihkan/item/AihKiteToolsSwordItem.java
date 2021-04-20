
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class AihKiteToolsSwordItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:aih_kite_tools_sword")
	public static final Item block = null;

	public AihKiteToolsSwordItem(AihkanModElements instance) {
		super(instance, 59);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1741;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 25f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 56;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(FusedAihkiteItem.block, (int) (1)));
			}
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("aih_kite_tools_sword"));
	}

}
