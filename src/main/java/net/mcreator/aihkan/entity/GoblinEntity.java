
package net.mcreator.aihkan.entity;

import net.minecraft.block.material.Material;

@AihkanModElements.ModElement.Tag
public class GoblinEntity extends AihkanModElements.ModElement {

	public static EntityType entity = null;

	public GoblinEntity(AihkanModElements instance) {
		super(instance, 113);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("goblin")
						.setRegistryName("goblin");

		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -16738048, -13408768, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("goblin_spawn_egg"));

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {

			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 16, 1, 2));
		}

		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);

		DungeonHooks.addDungeonMob(entity, 180);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelgoblinEntity(), 0.5f) {
				{
					this.addLayer(new GlowingLayer<>(this));
				}
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("aihkan:textures/goblintexture00.png");
				}
			};
		});

	}

	public static class CustomEntity extends MonsterEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 10;
			setNoAI(false);

		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true));
			this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 0.8));
			this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, (float) 0.5));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new RestrictSunGoal(this));
			this.goalSelector.addGoal(6, new BreakDoorGoal(this, e -> true));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEAD;
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
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();

			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);

			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14);

			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK);
			this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(0.2D);

		}

	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("aihkan:textures/goblintexture00.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}

	}

	// Made with Blockbench 3.8.3
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports

	public static class ModelgoblinEntity extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer chest;
		private final ModelRenderer cube_r1;
		private final ModelRenderer Rarm;
		private final ModelRenderer Larm;
		private final ModelRenderer Rleg;
		private final ModelRenderer Lleg;

		public ModelgoblinEntity() {
			textureWidth = 32;
			textureHeight = 32;

			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 24.0F, 0.0F);
			head.setTextureOffset(8, 11).addBox(-3.0F, -14.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			head.setTextureOffset(4, 28).addBox(3.0F, -13.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(10, 23).addBox(3.0F, -15.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(10, 28).addBox(-4.0F, -13.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(4, 23).addBox(-4.0F, -15.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

			chest = new ModelRenderer(this);
			chest.setRotationPoint(0.0F, 19.0F, 1.0F);

			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 4.0F, -0.5F);
			chest.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.3054F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(16, 23).addBox(-2.5F, -7.0F, 0.5F, 5.0F, 6.0F, 3.0F, 0.0F, false);

			Rarm = new ModelRenderer(this);
			Rarm.setRotationPoint(-3.0F, 16.0F, -0.5F);
			Rarm.setTextureOffset(0, 23).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

			Larm = new ModelRenderer(this);
			Larm.setRotationPoint(3.0F, 16.0F, -0.5F);
			Larm.setTextureOffset(0, 14).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

			Rleg = new ModelRenderer(this);
			Rleg.setRotationPoint(-1.5F, 21.0F, 2.0F);
			Rleg.setTextureOffset(0, 6).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

			Lleg = new ModelRenderer(this);
			Lleg.setRotationPoint(1.5F, 21.0F, 2.0F);
			Lleg.setTextureOffset(8, 6).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			chest.render(matrixStack, buffer, packedLight, packedOverlay);
			Rarm.render(matrixStack, buffer, packedLight, packedOverlay);
			Larm.render(matrixStack, buffer, packedLight, packedOverlay);
			Rleg.render(matrixStack, buffer, packedLight, packedOverlay);
			Lleg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.Lleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Rleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Rarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}

}
