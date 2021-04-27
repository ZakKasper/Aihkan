package net.mcreator.aihkan.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.aihkan.item.SnakevenomItem;
import net.mcreator.aihkan.AihkanModElements;

import java.util.Random;
import java.util.Map;

@AihkanModElements.ModElement.Tag
public class SnakevenomBulletHitsPlayerProcedure extends AihkanModElements.ModElement {
	public SnakevenomBulletHitsPlayerProcedure(AihkanModElements instance) {
		super(instance, 118);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SnakevenomBulletHitsPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure SnakevenomBulletHitsPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
			SnakevenomItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 2, (float) 5, (int) 3);
		}
		entity.attackEntityFrom(DamageSource.IN_FIRE, (float) 1);
	}
}
