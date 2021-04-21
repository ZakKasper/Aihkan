package net.mcreator.aihkan.procedures;

@AihkanModElements.ModElement.Tag
public class MurderBotBoltRangedItemUsedProcedure extends AihkanModElements.ModElement {

	public MurderBotBoltRangedItemUsedProcedure(AihkanModElements instance) {
		super(instance, 114);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure MurderBotBoltRangedItemUsed!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(BotboltitemItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(BotboltitemItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.OFF_HAND, true);
			}
		}

	}

}
