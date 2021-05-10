package me.posotrite.hanukkahhack;

import org.lwjgl.input.Keyboard;

import me.posotrite.hanukkahhack.clickgui.ClickGui;
import me.posotrite.hanukkahhack.miscs.Discord;
import me.posotrite.hanukkahhack.miscs.Hud;
import me.posotrite.hanukkahhack.miscs.SaveLoad;
import me.posotrite.hanukkahhack.miscs.SettingsManager;
import me.posotrite.hanukkahhack.module.Module;
import me.posotrite.hanukkahhack.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class Hanukkah {
	
	public static Hanukkah instance;
	 public static ModuleManager moduleManager;
	 public static Hud hud;
	 public SettingsManager settingsManager;
	 public ClickGui clickGui;
	 public SaveLoad saveLoad;
	 public Discord discordRPC;
	 public static void printMessage(String msg) {
	      Minecraft.getMinecraft().ingameGUI.addChatMessage(ChatType.SYSTEM, new TextComponentString(TextFormatting.BLUE + "[Posotrite] " + TextFormatting.RESET + msg));
	    }

	 public void init() {
		 MinecraftForge.EVENT_BUS.register(this);
		 settingsManager = new SettingsManager();
		 MinecraftForge.EVENT_BUS.register(new Hud());
		 moduleManager = new ModuleManager();
		 hud = new Hud();
		 clickGui = new ClickGui();
		 saveLoad = new SaveLoad();
		 discordRPC = new Discord();
	 }
	 @SubscribeEvent
	    public void key(KeyInputEvent e) {
	    	if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
	    		return; 
	    	try {
	             if (Keyboard.isCreated()) {
	                 if (Keyboard.getEventKeyState()) {
	                     int keyCode = Keyboard.getEventKey();
	                     if (keyCode <= 0)
	                    	 return;
	                     for (Module m : moduleManager.modules) {
	                    	 if (m.getKey() == keyCode && keyCode > 0) {
	                    		 m.toggle();
	                    	 }
	                     }
	                 }
	             }
	         } catch (Exception q) { q.printStackTrace(); }
	    }
	}

