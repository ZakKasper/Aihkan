
package net.mcreator.aihkan.item;

@AihkanModElements.ModElement.Tag
public class TihttriumArmorItem extends AihkanModElements.ModElement {

	@ObjectHolder("aihkan:tihttrium_armor_helmet")
	public static final Item helmet = null;

	@ObjectHolder("aihkan:tihttrium_armor_chestplate")
	public static final Item body = null;

	@ObjectHolder("aihkan:tihttrium_armor_leggings")
	public static final Item legs = null;

	@ObjectHolder("aihkan:tihttrium_armor_boots")
	public static final Item boots = null;

	public TihttriumArmorItem(AihkanModElements instance) {
		super(instance, 92);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 40;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{8, 12, 11, 8}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 20;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PureTihttriumItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "tihttrium_armor";
			}

			public float getToughness() {
				return 2.5f;
			}
		};

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(AihkanItemsItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aihkan:textures/models/armor/tihttrium_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("tihttrium_armor_helmet"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(AihkanItemsItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aihkan:textures/models/armor/tihttrium_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("tihttrium_armor_chestplate"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(AihkanItemsItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aihkan:textures/models/armor/tihttrium_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("tihttrium_armor_leggings"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(AihkanItemsItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aihkan:textures/models/armor/tihttrium_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("tihttrium_armor_boots"));
	}

}
