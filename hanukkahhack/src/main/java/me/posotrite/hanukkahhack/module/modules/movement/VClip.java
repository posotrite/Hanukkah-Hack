package me.posotrite.hanukkahhack.module.modules.movement;

import me.posotrite.hanukkahhack.Hanukkah;
import me.posotrite.hanukkahhack.miscs.Setting;
import me.posotrite.hanukkahhack.module.Category;
import me.posotrite.hanukkahhack.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;



@SideOnly(Side.CLIENT)
public class VClip extends Module {

  public VClip() {
    super("vclip", "teleport upwards", Category.MOVEMENT);
    this.setKey(0);
    Hanukkah.instance.settingsManager.rSetting(new Setting("Height", this, 0, 0, 10, true));
    
  }
@SubscribeEvent
public void toggle() {
	  int height = (int) Hanukkah.instance.settingsManager.getSettingByName(this, "Height").getValDouble();
	  Minecraft mc = Minecraft.getMinecraft();
	        double weight = height;
	        Entity target = mc.player.isRiding() ? mc.player.getRidingEntity() : mc.player;
	        target.setPosition(target.posX, target.posY + weight, target.posZ);	        
	      } 
}

