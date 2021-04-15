package net.mcreator.aihkan.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.aihkan.entity.BronzeGiantEntity;
import net.mcreator.aihkan.AihkanModElements;

import java.util.Map;

@AihkanModElements.ModElement.Tag
public class SciTowerAdditionalGenerationConditionProcedure extends AihkanModElements.ModElement {
	public SciTowerAdditionalGenerationConditionProcedure(AihkanModElements instance) {
		super(instance, 67);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SciTowerAdditionalGenerationCondition!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure SciTowerAdditionalGenerationCondition!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure SciTowerAdditionalGenerationCondition!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure SciTowerAdditionalGenerationCondition!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((world.getSpawnPoint().getX()) + 40) >= (entity.getPosX())) && (((world.getSpawnPoint().getX()) - 40) <= (entity.getPosX())))) {
			if (((((world.getSpawnPoint().getY()) + 40) >= (entity.getPosY())) && (((world.getSpawnPoint().getY()) - 40) <= (entity.getPosY())))) {
				if (((((world.getSpawnPoint().getZ()) + 40) >= (entity.getPosZ()))
						&& (((world.getSpawnPoint().getZ()) - 40) <= (entity.getPosZ())))) {
					if (world instanceof World && !world.getWorld().isRemote) {
						Entity entityToSpawn = new BronzeGiantEntity.CustomEntity(BronzeGiantEntity.entity, world.getWorld());
						entityToSpawn.setLocationAndAngles(x, ((world.getSpawnPoint().getY()) + 15), z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
									SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
