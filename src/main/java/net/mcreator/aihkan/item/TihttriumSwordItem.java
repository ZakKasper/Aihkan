
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class TihttriumSwordItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:tihttrium_sword")
	public static final Item block = null;

	public TihttriumSwordItem(AihkanModElements instance) {
		super(instance, 84);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 250;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PureTihttriumItem.block, (int) (1)));
			}
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("tihttrium_sword"));
	}

}
