package me.posotrite.hanukkahhack.module;

import java.util.ArrayList;
import java.util.List;

import me.posotrite.hanukkahhack.Hanukkah;
import me.posotrite.hanukkahhack.module.modules.combat.AutoArmor;
import me.posotrite.hanukkahhack.module.modules.combat.AutoClicker;
import me.posotrite.hanukkahhack.module.modules.combat.AutoTotem;
import me.posotrite.hanukkahhack.module.modules.combat.Velocity;
import me.posotrite.hanukkahhack.module.modules.misc.CommandsModule;
import me.posotrite.hanukkahhack.module.modules.misc.DiscordRPC;
import me.posotrite.hanukkahhack.module.modules.misc.Huds;
import me.posotrite.hanukkahhack.module.modules.misc.Scarfchat;
import me.posotrite.hanukkahhack.module.modules.movement.Sprint;
import me.posotrite.hanukkahhack.module.modules.movement.VClip;
import me.posotrite.hanukkahhack.module.modules.player.AutoLog;
import me.posotrite.hanukkahhack.module.modules.render.Brightness;
import me.posotrite.hanukkahhack.module.modules.render.ClickGUI;

public class ModuleManager {
	
	public ArrayList<Module> modules;
	
	public ModuleManager() {
		(modules = new ArrayList<Module>()).clear();
		//Combat
		this.modules.add(new AutoClicker());
		this.modules.add(new AutoTotem());
		this.modules.add(new Velocity());
		//Render
		this.modules.add(new ClickGUI());
		this.modules.add(new Brightness());
		//Player
		this.modules.add(new AutoLog());
		//Movement
		this.modules.add(new Sprint());
		this.modules.add(new VClip());
		//Misc
		this.modules.add(new CommandsModule());
		this.modules.add(new DiscordRPC());
		this.modules.add(new Huds());
		
	}
	
	public Module getModule (String name) {
		for(Module m : this.modules) {
			if(m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Module> getModuleList() {
		return this.modules;
	}
	
	public static List<Module> getModulesByCategory(Category c){
		List<Module> modules = new ArrayList<Module>();
		
		for(Module m : Hanukkah.moduleManager.modules) {
			if(m.getCategory() == c)
				modules.add(m);
		}
		return modules;
	} 
}
