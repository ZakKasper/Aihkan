// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modeladam extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer armR;
	private final ModelRenderer legL;
	private final ModelRenderer legR;
	private final ModelRenderer neck;
	private final ModelRenderer armL;
	private final ModelRenderer torso;
	private final ModelRenderer chest;
	private final ModelRenderer hips;

	public Modeladam() {
		textureWidth = 32;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.setTextureOffset(20, 26).addBox(-1.0F, -15.0F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		armR = new ModelRenderer(this);
		armR.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(armR);
		armR.setTextureOffset(28, 18).addBox(-2.5F, -10.0F, 0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		legL = new ModelRenderer(this);
		legL.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(legL);
		legL.setTextureOffset(24, 18).addBox(1.0F, -4.0F, 0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		legR = new ModelRenderer(this);
		legR.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(legR);
		legR.setTextureOffset(20, 18).addBox(-1.0F, -4.0F, 0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(neck);
		neck.setTextureOffset(28, 23).addBox(0.0F, -12.0F, 0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		armL = new ModelRenderer(this);
		armL.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(armL);
		armL.setTextureOffset(28, 18).addBox(2.5F, -10.0F, 0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, 24.0F, 0.0F);
		torso.setTextureOffset(0, 27).addBox(-1.0F, -9.0F, 0.5F, 3.0F, 4.0F, 1.0F, 0.0F, false);

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, 24.0F, 0.0F);
		chest.setTextureOffset(8, 29).addBox(-1.5F, -10.0F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		hips = new ModelRenderer(this);
		hips.setRotationPoint(0.0F, 24.0F, 0.0F);
		hips.setTextureOffset(0, 24).addBox(-1.5F, -5.0F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		torso.render(matrixStack, buffer, packedLight, packedOverlay);
		chest.render(matrixStack, buffer, packedLight, packedOverlay);
		hips.render(matrixStack, buffer, packedLight, packedOverlay);
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
		this.legR.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.armR.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.legL.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.armL.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}