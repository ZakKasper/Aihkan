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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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