// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModeldroidPassive extends EntityModel<Entity> {
	private final ModelRenderer Wheel;
	private final ModelRenderer cube_r10_r1;
	private final ModelRenderer bb_main;

	public ModeldroidPassive() {
		textureWidth = 16;
		textureHeight = 16;

		Wheel = new ModelRenderer(this);
		Wheel.setRotationPoint(1.5F, 23.0F, 2.0F);
		setRotationAngle(Wheel, 0.0F, 3.1416F, 0.0F);
		Wheel.setTextureOffset(0, 0).addBox(0.0F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Wheel.setTextureOffset(0, 0).addBox(0.0F, -0.5F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r10_r1 = new ModelRenderer(this);
		cube_r10_r1.setRotationPoint(2.5F, 0.0F, 3.0F);
		Wheel.addChild(cube_r10_r1);
		setRotationAngle(cube_r10_r1, 0.0F, 3.1416F, 0.0F);
		cube_r10_r1.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r10_r1.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(2, 8).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(8, 0).addBox(-0.5F, -2.5F, 1.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(8, 0).addBox(0.2F, -2.7F, -0.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(8, 0).addBox(-1.2F, -2.7F, -0.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 3).addBox(-0.5F, -3.2F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Wheel.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}