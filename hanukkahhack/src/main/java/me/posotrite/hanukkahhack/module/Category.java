package me.posotrite.hanukkahhack.module;

public enum Category {
	COMBAT("Combat"), RENDER("Render"), PLAYER("Player"), MOVEMENT("Movement"), MISC("Misc");

	public String name;
	public int moduleIndex;
	
	Category(String name) {
		this.name = name;
	}
}
