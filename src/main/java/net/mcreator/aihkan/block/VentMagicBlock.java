
package net.mcreator.aihkan.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.Entity;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.aihkan.procedures.SpawnBossManProcedure;
import net.mcreator.aihkan.itemgroup.AihkanItemsItemGroup;
import net.mcreator.aihkan.AihkanModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@AihkanModElements.ModElement.Tag
public class VentMagicBlock extends AihkanModElements.ModElement {
	@ObjectHolder("aihkan:vent_magic")
	public static final Block block = null;
	public VentMagicBlock(AihkanModElements instance) {
		super(instance, 131);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AihkanItemsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(-1, 3600000).lightValue(0).harvestLevel(5)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("vent_magic");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 0));
		}

		@Override
		public void onEntityWalk(World world, BlockPos pos, Entity entity) {
			super.onEntityWalk(world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SpawnBossManProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
