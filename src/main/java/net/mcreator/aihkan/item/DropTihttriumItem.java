
package net.mcreator.aihkan.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.aihkan.itemgroup.AihkanItemsItemGroup;
import net.mcreator.aihkan.AihkanModElements;

@AihkanModElements.ModElement.Tag
public class DropTihttriumItem extends AihkanModElements.ModElement {
	@ObjectHolder("aihkan:drop_tihttrium")
	public static final Item block = null;
	public DropTihttriumItem(AihkanModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AihkanItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("drop_tihttrium");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
