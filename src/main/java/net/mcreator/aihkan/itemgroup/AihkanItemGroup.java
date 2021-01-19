
package net.mcreator.aihkan.itemgroup;

@AihkanModElements.ModElement.Tag
public class AihkanItemGroup extends AihkanModElements.ModElement {

	public AihkanItemGroup(AihkanModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaihkan") {
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
