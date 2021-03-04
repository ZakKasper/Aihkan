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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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