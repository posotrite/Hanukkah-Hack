package me.posotrite.hanukkahhack.module;

import me.posotrite.hanukkahhack.Hanukkah;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class Module {

	protected Minecraft mc = Minecraft.getMinecraft();
	public String name, description;
	private int key;
	private Category category;
	public boolean toggled;
	public boolean visible;
	
	public Module(String name, String description, Category category) {
		super();
		this.name = name;
		this.description = description;
		this.key = 0;
		this.category = category;
		this.toggled = false;
		this.visible = true;
	}
	public boolean isvisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
		if (Hanukkah.instance.saveLoad != null) {
			Hanukkah.instance.saveLoad.save();
		}
	}
	public void unVisible() {
		this.visible = !this.visible;
		if (Hanukkah.instance.saveLoad != null) {
			Hanukkah.instance.saveLoad.save();
		}
		
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
		if (Hanukkah.instance.saveLoad != null) {
			Hanukkah.instance.saveLoad.save();
		}
	}
	
	public boolean isToggled() {
		return toggled;
	}
	
	public void setToggled(boolean toggled) { 
		this.toggled = toggled;
		if(this.toggled) {
			this.onEnable();
		}else {
			this.onDisable();
		}
		if (Hanukkah.instance.saveLoad != null) {
			Hanukkah.instance.saveLoad.save();
		}
	}
	
	public void toggle() {
		this.toggled = !this.toggled;
		
		if(this.toggled) {
			this.onEnable();
		}else {
			this.onDisable();
		}
		if (Hanukkah.instance.saveLoad != null) {
			Hanukkah.instance.saveLoad.save();
		}
	}
	public void onEnable() {
		MinecraftForge.EVENT_BUS.register(this);
	
	}

	public void onDisable() { 
		MinecraftForge.EVENT_BUS.unregister(this);
	}
	
	public String getName() {
		return this.name;
	}
	public Category getCategory() {
		return this.category;
	}
	  public boolean nullCheck() {
	        return mc.player == null || mc.world == null;
	    }
	    public void onUpdate() {}
}
