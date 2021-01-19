
package net.mcreator.aihkan.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.aihkan.block.SihkumiteOreBlock;
import net.mcreator.aihkan.AihkanModElements;

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
