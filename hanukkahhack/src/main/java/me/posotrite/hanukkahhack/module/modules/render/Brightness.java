package me.posotrite.hanukkahhack.module.modules.render;

import me.posotrite.hanukkahhack.Hanukkah;
import me.posotrite.hanukkahhack.miscs.Setting;
import me.posotrite.hanukkahhack.module.Category;
import me.posotrite.hanukkahhack.module.Module;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Brightness extends Module{
 public Brightness() {
	 super("Brightness", "Modify Game Brightness", Category.RENDER);
	 this.setKey(0);
	 Hanukkah.instance.settingsManager.rSetting(new Setting("Gamma Level", this, 0, 0, 10, true));
	 }
@SubscribeEvent
public void onLivingUpdate(LivingUpdateEvent e) {
	int level = (int) Hanukkah.instance.settingsManager.getSettingByName(this, "Gamma Level").getValDouble();
	super.onEnable();
	mc.gameSettings.gammaSetting = level;
}

@Override
public void onDisable() {
	mc.gameSettings.gammaSetting = 1f;
	super.onDisable();
}


 }

