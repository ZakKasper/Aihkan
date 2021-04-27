
package net.mcreator.aihkan.entity;

import net.minecraft.block.material.Material;

@AihkanModElements.ModElement.Tag
public class MurderBotEntity extends AihkanModElements.ModElement {

	public static EntityType entity = null;

	public MurderBotEntity(AihkanModElements instance) {
		super(instance, 41);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("murder_bot")
						.setRegistryName("murder_bot");

		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -16758776, -13969937, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("murder_bot_spawn_egg"));

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("aihkan:wasteland")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;

			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 10, 1, 2));
		}

		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);

	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelmurderBot(), 0.5f) {
				{
					this.addLayer(new GlowingLayer<>(this));
				}
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("aihkan:textures/murderbottexture.png");
				}
			};
		});

	}

	public static class CustomEntity extends CreatureEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);

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
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, (float) 0.5));
			this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 1));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public double getMountedYOffset() {
			return super.getMountedYOffset() + 0.3;
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
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();

			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);

			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);

			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4);

			if (this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
			this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.5D);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK);
			this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(1D);

		}

	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("aihkan:textures/murderbottexture.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}

	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	public static class ModelmurderBot extends EntityModel<Entity> {
		private final ModelRenderer bb_main;

		public ModelmurderBot() {
			textureWidth = 128;
			textureHeight = 128;

			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.25F, 14.5714F, -0.5357F);
			bb_main.setTextureOffset(0, 0).addBox(-4.25F, -6.5714F, -3.4643F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 37).addBox(-3.25F, -7.8214F, -2.4643F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 24).addBox(-3.25F, -5.5714F, -3.7143F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 16).addBox(-2.25F, -4.5714F, -3.9643F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 52).addBox(-0.75F, 1.1786F, -2.9643F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 70).addBox(-2.75F, 1.1786F, 1.0357F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 60).addBox(1.5F, 1.1786F, 0.5357F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

		}
	}

}
