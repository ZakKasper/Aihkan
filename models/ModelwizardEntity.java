// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelwizardEntity extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Chest;
	private final ModelRenderer Chest_r1;
	private final ModelRenderer Rarm;
	private final ModelRenderer Rarm_r1;
	private final ModelRenderer Larm;
	private final ModelRenderer Larm_r1;
	private final ModelRenderer Rleg;
	private final ModelRenderer Rleg_r1;
	private final ModelRenderer Lleg;
	private final ModelRenderer Lleg_r1;

	public ModelwizardEntity() {
		textureWidth = 128;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 2.0F, 0.0F);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setRotationPoint(0.0F, 22.0F, 0.0F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.0F, -1.5708F, 0.0F);
		Head_r1.setTextureOffset(64, 36).addBox(-3.0F, -38.0F, -3.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);
		Head_r1.setTextureOffset(29, 32).addBox(-4.0F, -34.0F, -4.0F, 8.0F, 3.0F, 8.0F, 0.0F, false);
		Head_r1.setTextureOffset(0, 19).addBox(-5.0F, -31.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		Head_r1.setTextureOffset(0, 0).addBox(-4.0F, -30.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Chest = new ModelRenderer(this);
		Chest.setRotationPoint(0.0F, 7.25F, 0.0F);

		Chest_r1 = new ModelRenderer(this);
		Chest_r1.setRotationPoint(0.0F, 16.75F, 0.0F);
		Chest.addChild(Chest_r1);
		setRotationAngle(Chest_r1, 0.0F, -1.5708F, 0.0F);
		Chest_r1.setTextureOffset(98, 33).addBox(-2.0F, -22.0F, -5.0F, 4.0F, 11.0F, 10.0F, 0.0F, false);
		Chest_r1.setTextureOffset(2, 43).addBox(-2.5F, -22.0F, -4.0F, 5.0F, 10.0F, 8.0F, 0.0F, false);

		Rarm = new ModelRenderer(this);
		Rarm.setRotationPoint(0.0F, 2.0F, 5.0F);

		Rarm_r1 = new ModelRenderer(this);
		Rarm_r1.setRotationPoint(0.0F, 22.0F, -5.0F);
		Rarm.addChild(Rarm_r1);
		setRotationAngle(Rarm_r1, 0.0F, -1.5708F, 0.0F);
		Rarm_r1.setTextureOffset(66, 20).addBox(-2.0F, -22.0F, 5.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);
		Rarm_r1.setTextureOffset(33, 44).addBox(-8.0F, -13.0F, 6.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		Larm = new ModelRenderer(this);
		Larm.setRotationPoint(0.0F, 2.0F, -5.0F);

		Larm_r1 = new ModelRenderer(this);
		Larm_r1.setRotationPoint(0.0F, 22.0F, 5.0F);
		Larm.addChild(Larm_r1);
		setRotationAngle(Larm_r1, 0.0F, -1.5708F, 0.0F);
		Larm_r1.setTextureOffset(48, 18).addBox(-2.0F, -22.0F, -9.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);

		Rleg = new ModelRenderer(this);
		Rleg.setRotationPoint(0.0F, 13.0F, 2.5F);

		Rleg_r1 = new ModelRenderer(this);
		Rleg_r1.setRotationPoint(0.0F, 11.0F, -2.5F);
		Rleg.addChild(Rleg_r1);
		setRotationAngle(Rleg_r1, 0.0F, -1.5708F, 0.0F);
		Rleg_r1.setTextureOffset(46, 1).addBox(-2.0F, -11.0F, 0.0F, 4.0F, 11.0F, 5.0F, 0.0F, false);

		Lleg = new ModelRenderer(this);
		Lleg.setRotationPoint(0.0F, 13.0F, -2.5F);

		Lleg_r1 = new ModelRenderer(this);
		Lleg_r1.setRotationPoint(0.0F, 11.0F, 2.5F);
		Lleg.addChild(Lleg_r1);
		setRotationAngle(Lleg_r1, 0.0F, -1.5708F, 0.0F);
		Lleg_r1.setTextureOffset(66, 1).addBox(-2.0F, -11.0F, -5.0F, 4.0F, 11.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Chest.render(matrixStack, buffer, packedLight, packedOverlay);
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.Larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.Lleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Rleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.Rarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}