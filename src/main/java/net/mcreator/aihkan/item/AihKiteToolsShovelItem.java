
package net.mcreator.aihkan.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aihkan.AihkanModElements;

@AihkanModElements.ModElement.Tag
public class AihKiteToolsShovelItem extends AihkanModElements.ModElement {
	@ObjectHolder("aihkan:aih_kite_tools_shovel")
	public static final Item block = null;
	public AihKiteToolsShovelItem(AihkanModElements instance) {
		super(instance, 60);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 1741;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 6f;
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
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("aih_kite_tools_shovel"));
	}
}
