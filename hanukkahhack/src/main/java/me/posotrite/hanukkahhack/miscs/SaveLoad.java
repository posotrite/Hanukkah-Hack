package me.posotrite.hanukkahhack.miscs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import me.posotrite.hanukkahhack.Hanukkah;
import me.posotrite.hanukkahhack.module.Module;
import net.minecraft.client.Minecraft;

public class SaveLoad {

	private File dir;
	private File dataFile;
	public SaveLoad() {
		dir = new File(Minecraft.getMinecraft().mcDataDir, "Hanukkah Hack");
		if (!dir.exists()) {
			dir.mkdir();
		}
		dataFile = new File(dir, "config.json");
		if (!dataFile.exists()) {
			try {
				dataFile.createNewFile();
			} catch (IOException e) {e.printStackTrace();}
		}		
		this.load();
	}
	
	
	public void save() {
		ArrayList<String> toSave = new ArrayList<String>();
		
		for (Module mod : Hanukkah.moduleManager.modules) {
			toSave.add("MOD:" + mod.getName() + ":" + mod.isToggled() + ":" + mod.getKey() + ":" + mod.isvisible());
		}
		
		for (Setting set : Hanukkah.instance.settingsManager.getSettings()) {
			if (set.isCheck()) {
				toSave.add("SET:" + set.getName() + ":" + set.getParentMod().getName() + ":" + set.getValBoolean());
			}
			if (set.isCombo()) {
				toSave.add("SET:" + set.getName() + ":" + set.getParentMod().getName() + ":" + set.getValString());
			}
			if (set.isSlider()) {
				toSave.add("SET:" + set.getName() + ":" + set.getParentMod().getName() + ":" + set.getValDouble());
			}
		}
		
		try {
			PrintWriter pw = new PrintWriter(this.dataFile);
			for (String str : toSave) {
				pw.println(str);
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void load() {
		
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(this.dataFile));
			String line = reader.readLine();
			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (String s : lines) {
			String[] args = s.split(":");
			if (s.toLowerCase().startsWith("mod:")) {
				Module m = Hanukkah.moduleManager.getModule(args[1]);
				if (m != null) {
					m.setToggled(Boolean.parseBoolean(args[2]));
					m.setKey(Integer.parseInt(args[3]));
					m.setVisible(Boolean.parseBoolean(args[4]));
				}
			} else if (s.toLowerCase().startsWith("set:")) {
				Module m = Hanukkah.moduleManager.getModule(args[2]);
				if (m != null) {
					Setting set = Hanukkah.instance.settingsManager.getSettingByName(m, args[1]);
					if (set != null) {
						if (set.isCheck()) {
							set.setValBoolean(Boolean.parseBoolean(args[3]));
						}
						if (set.isCombo()) {
							set.setValString(args[3]);
						}
					}
				}
			}
		}
	}
	
}
