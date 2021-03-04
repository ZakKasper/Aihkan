
package net.mcreator.aihkan.entity;

import net.minecraft.block.material.Material;

@AihkanModElements.ModElement.Tag
public class BronzeGiantEntity extends AihkanModElements.ModElement {

	public static EntityType entity = null;

	public BronzeGiantEntity(AihkanModElements instance) {
		super(instance, 40);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("bronze_giant")
						.setRegistryName("bronze_giant");

		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -7459072, -1933568, new Item.Properties().group(AihkanItemsItemGroup.tab))
				.setRegistryName("bronze_giant_spawn_egg"));

	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelbronzeGiant(), 0.5f) {
				{
					this.addLayer(new GlowingLayer<>(this));
				}
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("aihkan:textures/bronzegiant.png");
				}
			};
		});

	}

	public static class CustomEntity extends IronGolemEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 500;
			setNoAI(false);

			enablePersistence();

		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, true));
			this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, ServerPlayerEntity.class, false, true));
			this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, (float) 0.2));
			this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 0.8));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(PureTihttriumItem.block, (int) (1)));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.step")),
					0.15f, 1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();

			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);

			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300);

			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(6);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);

		}

		@Override
		public boolean isNonBoss() {
			return false;
		}

		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PINK, BossInfo.Overlay.NOTCHED_20);

		@Override
		public void addTrackingPlayer(ServerPlayerEntity player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(ServerPlayerEntity player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void updateAITasks() {
			super.updateAITasks();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}

	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("aihkan:textures/bronzegiant.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}

	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	public static class ModelbronzeGiant extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer chest;
		private final ModelRenderer belly;
		private final ModelRenderer hips;
		private final ModelRenderer lArm;
		private final ModelRenderer lHand;
		private final ModelRenderer rArm;
		private final ModelRenderer rHand;
		private final ModelRenderer rLeg;
		private final ModelRenderer lLeg;

		public ModelbronzeGiant() {
			textureWidth = 128;
			textureHeight = 128;

			head = new ModelRenderer(this);
			head.setRotationPoint(0.5F, -12.0F, -0.5F);
			head.setTextureOffset(0, 0).addBox(-4.0F, -9.0F, -5.0F, 8.0F, 9.0F, 10.0F, 0.0F, false);

			chest = new ModelRenderer(this);
			chest.setRotationPoint(0.0F, -2.0F, 0.5F);
			chest.setTextureOffset(0, 23).addBox(-8.0F, -10.0F, -4.0F, 16.0F, 20.0F, 8.0F, 0.0F, false);

			belly = new ModelRenderer(this);
			belly.setRotationPoint(0.0F, 0.0F, -0.5F);
			belly.setTextureOffset(0, 55).addBox(-7.0F, -7.0F, -4.0F, 14.0F, 14.0F, 8.0F, 0.0F, false);

			hips = new ModelRenderer(this);
			hips.setRotationPoint(0.0F, 10.0F, 0.0F);
			hips.setTextureOffset(0, 81).addBox(-8.0F, -2.0F, -3.0F, 16.0F, 4.0F, 6.0F, 0.0F, false);

			lArm = new ModelRenderer(this);
			lArm.setRotationPoint(8.0F, -11.0F, 0.25F);
			lArm.setTextureOffset(25, 94).addBox(0.0F, -1.0F, -3.75F, 6.0F, 26.0F, 8.0F, 0.0F, false);

			lHand = new ModelRenderer(this);
			lHand.setRotationPoint(3.0F, 27.0F, 0.25F);
			lArm.addChild(lHand);
			lHand.setTextureOffset(0, 98).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

			rArm = new ModelRenderer(this);
			rArm.setRotationPoint(-8.0F, -11.0F, 0.25F);
			rArm.setTextureOffset(54, 94).addBox(-6.0F, -1.0F, -3.75F, 6.0F, 26.0F, 8.0F, 0.0F, false);

			rHand = new ModelRenderer(this);
			rHand.setRotationPoint(-3.0F, 27.0F, 0.25F);
			rArm.addChild(rHand);
			rHand.setTextureOffset(0, 98).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

			rLeg = new ModelRenderer(this);
			rLeg.setRotationPoint(-4.0F, 12.0F, 0.0F);
			rLeg.setTextureOffset(0, 110).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F, 0.0F, false);

			lLeg = new ModelRenderer(this);
			lLeg.setRotationPoint(4.0F, 12.0F, 0.0F);
			lLeg.setTextureOffset(0, 110).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			chest.render(matrixStack, buffer, packedLight, packedOverlay);
			belly.render(matrixStack, buffer, packedLight, packedOverlay);
			hips.render(matrixStack, buffer, packedLight, packedOverlay);
			lArm.render(matrixStack, buffer, packedLight, packedOverlay);
			rArm.render(matrixStack, buffer, packedLight, packedOverlay);
			rLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			lLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.lLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.lArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.rLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}

}
