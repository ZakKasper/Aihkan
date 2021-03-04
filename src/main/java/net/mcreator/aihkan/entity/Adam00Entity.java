
package net.mcreator.aihkan.entity;

import net.minecraft.block.material.Material;

@AihkanModElements.ModElement.Tag
public class Adam00Entity extends AihkanModElements.ModElement {

	public static EntityType entity = null;

	public Adam00Entity(AihkanModElements instance) {
		super(instance, 39);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("adam_00")
						.setRegistryName("adam_00");

		elements.entities.add(() -> entity);

		elements.items.add(
				() -> new SpawnEggItem(entity, -29638, -13750738, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("adam_00_spawn_egg"));

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {

			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 8, 4, 4));
		}

		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));

		DungeonHooks.addDungeonMob(entity, 180);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modeladam(), 0.5f) {
				{
					this.addLayer(new GlowingLayer<>(this));
				}
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("aihkan:textures/adam00.png");
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

			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 0.8));
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(4, new MoveTowardsVillageGoal(this, 0.5));
			this.goalSelector.addGoal(5, new OpenDoorGoal(this, true));
			this.goalSelector.addGoal(6, new OpenDoorGoal(this, false));
			this.goalSelector.addGoal(7, new BreakDoorGoal(this, e -> true));
			this.goalSelector.addGoal(8, new FollowMobGoal(this, (float) 1, 10, 5));
			this.goalSelector.addGoal(9, new BreakBlockGoal(Blocks.STONE.getDefaultState().getBlock(), this, 1, (int) 3));
			this.goalSelector.addGoal(10, new PanicGoal(this, 1.2));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(RubbleItem.block, (int) (1)));
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
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);

		}

	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("aihkan:textures/adam00.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}

	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	public static class Modeladam extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer neck;
		private final ModelRenderer armR;
		private final ModelRenderer armL;
		private final ModelRenderer torso;
		private final ModelRenderer chest;
		private final ModelRenderer hips;
		private final ModelRenderer legR;
		private final ModelRenderer legL;

		public Modeladam() {
			textureWidth = 64;
			textureHeight = 64;

			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.5F);
			head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

			neck = new ModelRenderer(this);
			neck.setRotationPoint(0.0F, 2.0F, 0.5F);
			neck.setTextureOffset(0, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

			armR = new ModelRenderer(this);
			armR.setRotationPoint(-4.0F, 5.0F, 0.5F);
			armR.setTextureOffset(0, 23).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

			armL = new ModelRenderer(this);
			armL.setRotationPoint(4.0F, 5.0F, 0.5F);
			armL.setTextureOffset(8, 23).addBox(0.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

			torso = new ModelRenderer(this);
			torso.setRotationPoint(0.0F, 10.0F, 0.5F);
			torso.setTextureOffset(40, 14).addBox(-3.0F, -4.0F, -1.0F, 6.0F, 8.0F, 2.0F, 0.0F, false);

			chest = new ModelRenderer(this);
			chest.setRotationPoint(0.0F, 5.0F, 0.5F);
			chest.setTextureOffset(32, 0).addBox(-4.0F, -1.0F, -2.0F, 8.0F, 2.0F, 4.0F, 0.0F, false);

			hips = new ModelRenderer(this);
			hips.setRotationPoint(0.0F, 15.0F, 0.5F);
			hips.setTextureOffset(32, 7).addBox(-4.0F, -1.0F, -2.0F, 8.0F, 2.0F, 4.0F, 0.0F, false);

			legR = new ModelRenderer(this);
			legR.setRotationPoint(-2.0F, 16.0F, 0.5F);
			legR.setTextureOffset(8, 33).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

			legL = new ModelRenderer(this);
			legL.setRotationPoint(2.0F, 16.0F, 0.5F);
			legL.setTextureOffset(0, 33).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			neck.render(matrixStack, buffer, packedLight, packedOverlay);
			armR.render(matrixStack, buffer, packedLight, packedOverlay);
			armL.render(matrixStack, buffer, packedLight, packedOverlay);
			torso.render(matrixStack, buffer, packedLight, packedOverlay);
			chest.render(matrixStack, buffer, packedLight, packedOverlay);
			hips.render(matrixStack, buffer, packedLight, packedOverlay);
			legR.render(matrixStack, buffer, packedLight, packedOverlay);
			legL.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.legR.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.armR.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.legL.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.armL.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}

}
