// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Chest;
	private final ModelRenderer Larm;
	private final ModelRenderer Rarm;
	private final ModelRenderer Lleg;
	private final ModelRenderer Rleg;

	public Modelcustom_model() {
		textureWidth = 32;
		textureHeight = 32;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.5F, 11.0F, 0.0F);
		Head.setTextureOffset(16, 20).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		Chest = new ModelRenderer(this);
		Chest.setRotationPoint(0.5F, 15.4F, 0.0F);
		Chest.setTextureOffset(28, 17).addBox(-0.5F, -4.4F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Chest.setTextureOffset(0, 12).addBox(-3.5F, -3.4F, -1.5F, 7.0F, 3.0F, 3.0F, 0.0F, false);
		Chest.setTextureOffset(0, 18).addBox(-1.5F, -0.4F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		Chest.setTextureOffset(28, 17).addBox(-0.5F, 1.6F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Chest.setTextureOffset(0, 22).addBox(-2.5F, 2.6F, -1.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);

		Larm = new ModelRenderer(this);
		Larm.setRotationPoint(4.0F, 13.5F, 0.0F);
		Larm.setTextureOffset(24, 28).addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Larm.setTextureOffset(28, 9).addBox(0.5F, -0.5F, -1.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Larm.setTextureOffset(28, 9).addBox(1.25F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Larm.setTextureOffset(28, 9).addBox(0.5F, -1.25F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Larm.setTextureOffset(28, 9).addBox(0.5F, -0.5F, 0.253F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Larm.setTextureOffset(8, 25).addBox(0.5F, 0.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		Rarm = new ModelRenderer(this);
		Rarm.setRotationPoint(-3.0F, 13.5F, 0.0F);
		Rarm.setTextureOffset(12, 28).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Rarm.setTextureOffset(24, 0).addBox(-2.0F, 4.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		Rarm.setTextureOffset(8, 25).addBox(-1.5F, 1.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Rarm.setTextureOffset(28, 11).addBox(-1.5F, -0.5F, 0.253F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rarm.setTextureOffset(28, 11).addBox(-2.25F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rarm.setTextureOffset(28, 11).addBox(-1.5F, -1.25F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rarm.setTextureOffset(28, 11).addBox(-1.5F, -0.5F, -1.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Lleg = new ModelRenderer(this);
		Lleg.setRotationPoint(2.0F, 19.0F, 0.0F);
		Lleg.setTextureOffset(0, 25).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		Rleg = new ModelRenderer(this);
		Rleg.setRotationPoint(-1.0F, 19.0F, 0.0F);
		Rleg.setTextureOffset(0, 25).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
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