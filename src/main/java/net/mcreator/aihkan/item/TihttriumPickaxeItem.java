
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class TihttriumPickaxeItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:tihttrium_pickaxe")
	public static final Item block = null;

	public TihttriumPickaxeItem(AihkanModElements instance) {
		super(instance, 82);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
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
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("tihttrium_pickaxe"));
	}

}
