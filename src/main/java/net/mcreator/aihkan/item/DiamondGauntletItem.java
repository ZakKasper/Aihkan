
package net.mcreator.aihkan.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.aihkan.itemgroup.AihkanItemsItemGroup;
import net.mcreator.aihkan.AihkanModElements;

@AihkanModElements.ModElement.Tag
public class DiamondGauntletItem extends AihkanModElements.ModElement {
	@ObjectHolder("aihkan:diamond_gauntlet")
	public static final Item block = null;
	public DiamondGauntletItem(AihkanModElements instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AihkanItemsItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("diamond_gauntlet");
		}

		@Override
		public int getItemEnchantability() {
			return 9;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 600F;
		}

		@Override
		public boolean canHarvestBlock(BlockState state) {
			return true;
		}
	}
}
