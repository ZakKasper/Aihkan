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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.lLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.lArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.rLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}