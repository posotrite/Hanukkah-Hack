 
package me.posotrite.hanukkahhack.module.modules.combat;
import com.mojang.realmsclient.gui.ChatFormatting;

import me.posotrite.hanukkahhack.module.Category;
import me.posotrite.hanukkahhack.module.Module;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoArmor extends Module {
	public AutoArmor() {
		super("Auto Armor", "Automatically Equip Armor", Category.COMBAT);
		this.setKey(0);
		
	}
    public int helmet;
    public int chest;
    public int legs;
    public int boots;
@SubscribeEvent
    public void onTick(TickEvent.RenderTickEvent e) {
	 if (nullCheck()) return;

     helmet = mc.player.inventory.mainInventory.stream().filter(itemStack -> itemStack.getItem() == Items.DIAMOND_HELMET).mapToInt(ItemStack::getCount).sum();
     chest = mc.player.inventory.mainInventory.stream().filter(itemStack -> itemStack.getItem() == Items.DIAMOND_CHESTPLATE).mapToInt(ItemStack::getCount).sum();
     legs = mc.player.inventory.mainInventory.stream().filter(itemStack -> itemStack.getItem() == Items.DIAMOND_LEGGINGS).mapToInt(ItemStack::getCount).sum();
     boots = mc.player.inventory.mainInventory.stream().filter(itemStack -> itemStack.getItem() == Items.DIAMOND_BOOTS).mapToInt(ItemStack::getCount).sum();

     if (mc.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == Items.DIAMOND_HELMET) return;

     final int slot = this.getItemSlot();

     if (slot != -1) {
         mc.playerController.windowClick(mc.player.inventoryContainer.windowId, slot, 0, ClickType.PICKUP, mc.player);
         mc.playerController.windowClick(mc.player.inventoryContainer.windowId, 45, 0, ClickType.PICKUP, mc.player);
         mc.playerController.windowClick(mc.player.inventoryContainer.windowId, slot, 0, ClickType.PICKUP, mc.player);
         mc.playerController.updateController();
     }
    }
@Override
public void onEnable() {
	super.onEnable();
}
    private int getItemSlot() {
        for (int i = 0; i < 36; i++) {
            final Item item = mc.player.inventory.getStackInSlot(i).getItem();
            if (item == Items.DIAMOND_HELMET) {
                if (i < 9) {
                    i += 36;
                }
                return i;
            }
        }
        return -1;
    }

    @Override
    public void onDisable() {
    	super.onDisable();
    }
}
