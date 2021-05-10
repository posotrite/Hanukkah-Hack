package me.posotrite.hanukkahhack.module.modules.combat;

import me.posotrite.hanukkahhack.Hanukkah;
import me.posotrite.hanukkahhack.miscs.Setting;
import me.posotrite.hanukkahhack.module.Category;
import me.posotrite.hanukkahhack.module.Module;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Velocity extends Module {

	public Velocity() {
		super("Velocity", "Reduces knockback", Category.COMBAT);
		Hanukkah.instance.settingsManager.rSetting(new Setting("Horizontal", this, 90, 0, 100, true));
		Hanukkah.instance.settingsManager.rSetting(new Setting("Vertical", this, 100, 0, 100, true));
	}
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent e) {
		if (mc.player == null) {
			return;
		}
		float horizontal = (float) Hanukkah.instance.settingsManager.getSettingByName(this, "Horizontal").getValDouble();
		float vertical = (float) Hanukkah.instance.settingsManager.getSettingByName(this, "Vertical").getValDouble();
		
		if (mc.player.hurtTime == mc.player.maxHurtTime && mc.player.maxHurtTime > 0) {
			mc.player.motionX *= (float) horizontal / 100;
			mc.player.motionY *= (float) vertical / 100;
			mc.player.motionZ *= (float) horizontal / 100;
		}
	}
}
