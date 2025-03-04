// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelsnakeEnitity00 extends EntityModel<Entity> {
	private final ModelRenderer tail;
	private final ModelRenderer neck;
	private final ModelRenderer head;
	private final ModelRenderer chest;

	public ModelsnakeEnitity00() {
		textureWidth = 64;
		textureHeight = 64;

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 24.0F, 0.0F);
		tail.setTextureOffset(0, 18).addBox(-4.0F, -10.0F, 4.0F, 8.0F, 10.0F, 6.0F, 0.0F, false);
		tail.setTextureOffset(40, 2).addBox(-3.0F, -14.0F, 4.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);
		tail.setTextureOffset(8, 4).addBox(-2.0F, -18.0F, 5.5F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 24.0F, 0.0F);
		neck.setTextureOffset(36, 28).addBox(-4.0F, -22.0F, -10.0F, 8.0F, 22.0F, 6.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 13.0F, -3.0F);
		head.setTextureOffset(0, 44).addBox(-4.0F, -19.0F, -13.0F, 8.0F, 8.0F, 12.0F, 0.0F, false);
		head.setTextureOffset(0, 34).addBox(-4.0F, -15.0F, -19.0F, 8.0F, 4.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-1.0F, -11.0F, -23.0F, 2.0F, 0.0F, 4.0F, 0.0F, false);

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, 24.0F, 0.0F);
		chest.setTextureOffset(32, 14).addBox(-4.0F, -6.0F, -4.0F, 8.0F, 6.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		neck.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		chest.render(matrixStack, buffer, packedLight, packedOverlay);
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
	}
}