package me.posotrite.hanukkahhack.module.modules.misc;

import me.posotrite.hanukkahhack.Hanukkah;
import me.posotrite.hanukkahhack.miscs.Setting;
import me.posotrite.hanukkahhack.module.Category;
import me.posotrite.hanukkahhack.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Huds extends Module{

	public static boolean mods;
	public static boolean logo;
	public static boolean on;
	public static int scale;
	public static boolean Versions;

	public Huds() {
		super("Hud", "Change in game gui and Hud overlays", Category.MISC);
		Hanukkah.instance.settingsManager.rSetting(new Setting("Module List", this, true));
		Hanukkah.instance.settingsManager.rSetting(new Setting("Logo", this, true));
		Hanukkah.instance.settingsManager.rSetting(new Setting("Logo Scale", this, 80, 0, 80, true));
		Hanukkah.instance.settingsManager.rSetting(new Setting("Version", this, true));
		
	}
	
	
	@SubscribeEvent
	public void onTick(TickEvent.RenderTickEvent e) {
		super.onEnable();
		this.updateVals();
	}
	@Override
	public void onEnable() {
		super.onEnable();
		this.updateVals();
	}
	@Override
	public void onDisable() {
		this.updateVals();
		super.onDisable();
	}
	private void updateVals() {
		logo = Hanukkah.instance.settingsManager.getSettingByName(this, "Logo").getValBoolean();
		mods = Hanukkah.instance.settingsManager.getSettingByName(this, "Module List").getValBoolean();
		Versions = Hanukkah.instance.settingsManager.getSettingByName(this, "Version").getValBoolean();
		on = this.isToggled();
		scale = (int) Hanukkah.instance.settingsManager.getSettingByName(this, "Logo Scale").getValDouble();
	}
	
	
	
}



