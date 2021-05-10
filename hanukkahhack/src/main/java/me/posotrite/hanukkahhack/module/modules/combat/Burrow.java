package me.posotrite.hanukkahhack.module.modules.combat;

import me.posotrite.hanukkahhack.Hanukkah;
import me.posotrite.hanukkahhack.miscs.Setting;
import me.posotrite.hanukkahhack.module.Category;
import me.posotrite.hanukkahhack.module.Module;
import me.posotrite.hanukkahhack.util.PlayerUtil;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;


public class Burrow extends Module {



 

	private Setting height;
	private Setting autoswitch;

	public Burrow() {
    	super("Burrow", "Fill blocks at your feet", Category.COMBAT);
    	 Hanukkah.instance.settingsManager.rSetting(autoswitch = new Setting("Auto Switch",this,true));
        Hanukkah.instance.settingsManager.rSetting(height = new Setting("Height", this, 1.14, 1.0, 2, true));
    }

    private BlockPos playerPos;

    @Override
    public void onEnable() {
    	  if (nullCheck()) return;
        playerPos = new BlockPos(mc.player.posX, mc.player.posY, mc.player.posZ);

        if (mc.world.getBlockState(playerPos).getBlock() == Blocks.OBSIDIAN) {
            toggle();
            return;
        }

        mc.player.jump();
        onUpdate();
    }

    public void onUpdate() {
    	mc.player.sendChatMessage("hi");
        if (nullCheck()) return;

        int oldSlot = -1;

        if (mc.player.posY > playerPos.getY() + height.getValDouble()) {

            if (autoswitch.getValBoolean()) {
            	mc.player.sendChatMessage("hi");
                oldSlot = mc.player.inventory.currentItem;
                mc.player.inventory.currentItem = PlayerUtil.getBlockInHotbar(Blocks.OBSIDIAN);
            }

            PlayerUtil.placeBlock(playerPos);

            if (autoswitch.getValBoolean()) {
                mc.player.inventory.currentItem = oldSlot;
            }

            mc.player.jump();
            toggle();
        }
    }

}