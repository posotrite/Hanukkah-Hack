package me.posotrite.hanukkahhack.module.modules.render;

import org.lwjgl.input.Keyboard;

import me.posotrite.hanukkahhack.Hanukkah;
import me.posotrite.hanukkahhack.module.Category;
import me.posotrite.hanukkahhack.module.Module;

public class ClickGUI extends Module {
	public ClickGUI() {
		super("ClickGUI", "menu.skeet", Category.RENDER);
		this.setKey(Keyboard.KEY_U);
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		mc.displayGuiScreen(Hanukkah.instance.clickGui);
		this.setToggled(false);
	}
}
