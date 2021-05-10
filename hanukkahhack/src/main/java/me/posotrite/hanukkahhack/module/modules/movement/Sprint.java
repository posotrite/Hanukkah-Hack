package me.posotrite.hanukkahhack.module.modules.movement;

import me.posotrite.hanukkahhack.module.Category;
import me.posotrite.hanukkahhack.module.Module;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Sprint extends Module {

	public Sprint() {
		super("Sprint", "auto runs when you hold w", Category.MOVEMENT);
		this.setKey(0);
	 }
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent e) {
		KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
	}
			
	}

