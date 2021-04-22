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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.Larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.Lleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Rleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.Rarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}