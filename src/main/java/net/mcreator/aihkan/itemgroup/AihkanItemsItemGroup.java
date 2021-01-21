
package net.mcreator.aihkan.itemgroup;

@AihkanModElements.ModElement.Tag
public class AihkanItemsItemGroup extends AihkanModElements.ModElement {

	public AihkanItemsItemGroup(AihkanModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaihkan_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SihkumiteOreItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
