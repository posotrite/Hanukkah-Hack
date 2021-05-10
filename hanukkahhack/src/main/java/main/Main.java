package main;

import me.posotrite.hanukkahhack.Hanukkah;
import me.posotrite.hanukkahhack.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
@Mod(modid = Refrence.MOD_ID, name = Refrence.NAME, version = Refrence.VERSION)
public class Main {
	@SidedProxy(clientSide = Refrence.CLIENT_PROXY_CLASS, serverSide = Refrence.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	@EventHandler
    public void init(FMLInitializationEvent event) {
    	Hanukkah.instance = new Hanukkah();
    	Hanukkah.instance.init();
}
}
