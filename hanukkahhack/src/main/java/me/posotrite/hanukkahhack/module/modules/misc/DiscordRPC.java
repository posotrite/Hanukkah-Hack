package me.posotrite.hanukkahhack.module.modules.misc;

import me.posotrite.hanukkahhack.miscs.Discord;
import me.posotrite.hanukkahhack.module.Category;
import me.posotrite.hanukkahhack.module.Module;

public class DiscordRPC extends Module{
	public DiscordRPC() {
		 super("DiscordRPC", "Change Discord Game Activity", Category.MISC);
		 this.setKey(0);
	}
	public void onEnable() {
		super.onEnable();
		Discord.startRPC();
	}
	@Override
	public void onDisable() {
		super.onDisable();
		Discord.stopRPC();
		
	}
}
