  
package me.posotrite.hanukkahhack.module.modules.player;


import me.posotrite.hanukkahhack.Hanukkah;
import me.posotrite.hanukkahhack.miscs.Setting;
import me.posotrite.hanukkahhack.module.Category;
import me.posotrite.hanukkahhack.module.Module;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;



public class AutoLog extends Module {
public AutoLog() {
	super("Auto Log", "Disconnect When Your Health Is Below A Certain Level", Category.PLAYER);
	this.setKey(0);
	 Hanukkah.instance.settingsManager.rSetting(new Setting("Health", this, 15, 0, 20, true));
}

@SubscribeEvent
public void onTick(TickEvent.RenderTickEvent e) {
	if (nullCheck()) return;
	float health = (float) Hanukkah.instance.settingsManager.getSettingByName(this, "Health").getValDouble();
	
	 if ( mc.player.getHealth() < health) {
			mc.world.sendQuittingDisconnectingPacket();
		    mc.loadWorld(null);
		    mc.displayGuiScreen(new GuiMainMenu());
		    toggle();
	 }
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