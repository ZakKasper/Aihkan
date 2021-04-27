
package net.mcreator.aihkan.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.mcreator.aihkan.item.MurderBotBoltItem;
import net.mcreator.aihkan.item.BotboltitemItem;
import net.mcreator.aihkan.AihkanModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@AihkanModElements.ModElement.Tag
public class CyborgEntity extends AihkanModElements.ModElement {
	public static EntityType entity = null;
	public CyborgEntity(AihkanModElements instance) {
		super(instance, 116);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("cyborg")
						.setRegistryName("cyborg");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -6684673, -6684775, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("cyborg_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 1, 1));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelcyborgModel(), 0.5f) {
				{
					this.addLayer(new GlowingLayer<>(this));
				}
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("aihkan:textures/cyborgtexture.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity implements IRangedAttackMob {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(BotboltitemItem.block, (int) (1)));
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, ServerPlayerEntity.class, false, false));
			this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(4, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(5, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(7, new SwimGoal(this));
			this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10) {
				@Override
				public boolean shouldContinueExecuting() {
					return this.shouldExecute();
				}
			});
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(BotboltitemItem.block, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			MurderBotBoltItem.shoot(this, target);
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("aihkan:textures/cyborgtexture.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class ModelcyborgModel extends EntityModel<Entity> {
		private final ModelRenderer Head;
		private final ModelRenderer Chest;
		private final ModelRenderer Larm;
		private final ModelRenderer Rarm;
		private final ModelRenderer Lleg;
		private final ModelRenderer Lleg_r1;
		private final ModelRenderer Rleg;
		private final ModelRenderer Rleg_r1;
		public ModelcyborgModel() {
			textureWidth = 64;
			textureHeight = 64;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, -4.0F, 1.0F);
			Head.setTextureOffset(32, 40).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			Chest = new ModelRenderer(this);
			Chest.setRotationPoint(0.1F, 5.0F, 1.0F);
			Chest.setTextureOffset(56, 60).addBox(-1.1F, -9.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			Chest.setTextureOffset(2, 24).addBox(-6.1F, -7.0F, -3.0F, 13.0F, 6.0F, 6.0F, 0.0F, false);
			Chest.setTextureOffset(0, 36).addBox(-3.1F, -1.0F, -2.0F, 6.0F, 4.0F, 4.0F, 0.0F, false);
			Chest.setTextureOffset(56, 60).addBox(-1.1F, 3.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			Chest.setTextureOffset(0, 12).addBox(-5.1F, 5.0F, -3.0F, 10.0F, 4.0F, 6.0F, 0.0F, false);
			Larm = new ModelRenderer(this);
			Larm.setRotationPoint(7.0F, 0.5F, 1.0005F);
			Larm.setTextureOffset(48, 56).addBox(0.0F, -2.0F, -2.0005F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			Larm.setTextureOffset(56, 18).addBox(1.0F, -1.0F, -2.2505F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			Larm.setTextureOffset(56, 18).addBox(2.25F, -1.0F, -1.0005F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			Larm.setTextureOffset(56, 18).addBox(1.0F, -2.25F, -1.0005F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			Larm.setTextureOffset(56, 18).addBox(1.0F, -1.0F, 0.2525F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			Larm.setTextureOffset(16, 50).addBox(1.0F, 1.5F, -1.0005F, 2.0F, 12.0F, 2.0F, 0.0F, false);
			Rarm = new ModelRenderer(this);
			Rarm.setRotationPoint(-6.0F, 0.5F, 1.0004F);
			Rarm.setTextureOffset(48, 56).addBox(-4.0F, -2.0F, -2.0004F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			Rarm.setTextureOffset(48, 0).addBox(-4.0F, 8.0F, -2.0004F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			Rarm.setTextureOffset(16, 56).addBox(-3.0F, 2.0F, -1.0004F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			Rarm.setTextureOffset(56, 22).addBox(-3.0F, -1.0F, 0.2526F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			Rarm.setTextureOffset(56, 22).addBox(-4.25F, -1.0F, -1.0004F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			Rarm.setTextureOffset(56, 22).addBox(-3.0F, -2.25F, -1.0004F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			Rarm.setTextureOffset(56, 22).addBox(-3.0F, -1.0F, -2.2504F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			Lleg = new ModelRenderer(this);
			Lleg.setRotationPoint(3.0F, 14.0F, 1.0F);
			Lleg_r1 = new ModelRenderer(this);
			Lleg_r1.setRotationPoint(0.0F, 5.0F, 0.0F);
			Lleg.addChild(Lleg_r1);
			setRotationAngle(Lleg_r1, 0.0F, 1.5708F, 0.0F);
			Lleg_r1.setTextureOffset(0, 50).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
			Rleg = new ModelRenderer(this);
			Rleg.setRotationPoint(-3.0F, 14.0F, 1.0F);
			Rleg_r1 = new ModelRenderer(this);
			Rleg_r1.setRotationPoint(0.0F, 5.0F, 0.0F);
			Rleg.addChild(Rleg_r1);
			setRotationAngle(Rleg_r1, 0.0F, -1.5708F, 0.0F);
			Rleg_r1.setTextureOffset(0, 50).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			Chest.render(matrixStack, buffer, packedLight, packedOverlay);
			Larm.render(matrixStack, buffer, packedLight, packedOverlay);
			Rarm.render(matrixStack, buffer, packedLight, packedOverlay);
			Lleg.render(matrixStack, buffer, packedLight, packedOverlay);
			Rleg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.Lleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Rleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Rarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
