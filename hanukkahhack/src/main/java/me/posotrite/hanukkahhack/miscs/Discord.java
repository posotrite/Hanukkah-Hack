package me.posotrite.hanukkahhack.miscs;

import me.posotrite.hanukkahhack.miscs.discordhelper.DiscordEventHandlers;
import me.posotrite.hanukkahhack.miscs.discordhelper.DiscordRPC;
import me.posotrite.hanukkahhack.miscs.discordhelper.DiscordRichPresence;


public class Discord {
public static  String discordID = "813152587150524488";
public static DiscordRichPresence discordRichP = new DiscordRichPresence();

public static DiscordRPC discordRPC = DiscordRPC.INSTANCE;


	public static void startRPC() {
		DiscordEventHandlers eventHandlers = new DiscordEventHandlers();
		eventHandlers.disconnected = ((var1, var2) -> System.out.println("Discord RPC disconnected, var1:" + var1 + ", var2: " + var2));
		
		
		discordRPC.Discord_Initialize(discordID, eventHandlers,true, null);
		
		discordRichP.startTimestamp = System.currentTimeMillis() / 1000L;
		discordRichP.details = "Developed by Posotrite";
		discordRichP.largeImageKey = "logo";
		discordRichP.largeImageText = "Hanukkah Hack";
		discordRichP.state = null;
		discordRPC.Discord_UpdatePresence(discordRichP);
	}
	public static void stopRPC() {
		discordRPC.Discord_Shutdown();
		discordRPC.Discord_ClearPresence();
	}
}
