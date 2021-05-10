 
package me.posotrite.hanukkahhack.module.modules.movement;
import com.mojang.realmsclient.gui.ChatFormatting;

import me.posotrite.hanukkahhack.Hanukkah;
import me.posotrite.hanukkahhack.miscs.Setting;
import me.posotrite.hanukkahhack.module.Category;
import me.posotrite.hanukkahhack.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Timer extends Module {
	public Timer() {
		super("Timer", "Change the Client tick speed", Category.MOVEMENT);
		this.setKey(0);

		
	}


@Override
public void onEnable() {
	super.onEnable();
}


    @Override
    public void onDisable() {
    	super.onDisable();
    }
}
