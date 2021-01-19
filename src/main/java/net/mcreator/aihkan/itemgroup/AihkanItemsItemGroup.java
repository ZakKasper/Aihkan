
package net.mcreator.aihkan.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.aihkan.block.SihkumiteOreBlock;
import net.mcreator.aihkan.AihkanModElements;

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
				return new ItemStack(SihkumiteOreBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
