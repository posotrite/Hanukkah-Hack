package me.posotrite.hanukkahhack.module.modules.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import me.posotrite.hanukkahhack.module.Category;
import me.posotrite.hanukkahhack.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextFormatting;

public class Scarfchat extends Module {
	
	private File dir;
	private File dataFile;
	public Scarfchat() {
		
		super("Scarf Chat", "makes a scarf color of the chat", Category.MISC);
		this.setKey(0);
		dir = new File(Minecraft.getMinecraft().mcDataDir, "Hanukkah Hack");
		if (!dir.exists()) {
			dir.mkdir();
		}
		dataFile = new File(dir, "spammer.txt");
		if (!dataFile.exists()) {
			try {
				dataFile.createNewFile();
			} catch (IOException e) {e.printStackTrace();}
		}
	}

@Override
public void onEnable() {
	
	super.onEnable();
	try {
		BufferedReader reader = new BufferedReader(new FileReader(this.dataFile));
		String spam = reader.readLine();
		reader.close();
		String m = "";
		for (int i = 0;  i < spam.length(); i++) {
			mc.player.sendChatMessage("hi");
			if (i%2 == 0) {
				m += spam.charAt(i);
			m = m+TextFormatting.BLUE;
			}
		}
		mc.player.sendChatMessage(m);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
@Override
public void onDisable() {
	super.onDisable();
}
}
	
