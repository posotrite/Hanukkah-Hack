package me.posotrite.hanukkahhack.miscs;

import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;

import main.Refrence;
import me.posotrite.hanukkahhack.Hanukkah;
import me.posotrite.hanukkahhack.module.Module;
import me.posotrite.hanukkahhack.module.modules.misc.Huds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Hud extends Gui{
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	public static class ModuleComparator implements Comparator<Module> {
		
		@Override
		public int compare(Module arg0, Module arg1) {
			if (Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
				return -1;
			}
			if (Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
				return 1;
			}
			return 0;
	}
}
	private final ResourceLocation watermark = new ResourceLocation(Refrence.MOD_ID, "textures/watermark.png");
	
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		
		Collections.sort(Hanukkah.moduleManager.modules, new ModuleComparator());
		ScaledResolution sr = new ScaledResolution(mc);
		FontRenderer fr = mc.fontRenderer;
		
		//client logo
		if(Huds.logo && Huds.on) {
		if(event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			ScaledResolution scaled = new ScaledResolution(mc);
			int width = scaled.getScaledWidth();
			int height = scaled.getScaledHeight();
			mc.renderEngine.bindTexture(watermark);
			drawScaledCustomSizeModalRect(width-101, height-210, 0, 0, 50, 50, Huds.scale+19, Huds.scale, 50, 50);
		}
		}
		//client name
		if(Huds.Versions && Huds.on) {
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			ScaledResolution scaled = new ScaledResolution(mc);
			int width = scaled.getScaledWidth();
			int height = scaled.getScaledHeight();
			fr.drawStringWithShadow("Hanukkah Hack" + " " + Refrence.VERSION, width -101, height-128, 0xffffff);
		}
		}
		//array list
		if(Huds.mods && Huds.on) {
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			int y = 2;
			final int[] counter = {1};
			for(Module mod : Hanukkah.moduleManager.getModuleList()) {
				if(!mod.getName().equalsIgnoreCase("TabGui") && mod.isToggled() && mod.visible) {
					fr.drawString(mod.getName(), sr.getScaledWidth() -fr.getStringWidth(mod.getName()) - 2, y, rainbow(counter[0]*300));
					y += fr.FONT_HEIGHT;
					counter[0]++;
				}
			}
		}
		}
		}
	
		
		public static int rainbow(int delay) {
			double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
			rainbowState %= 360;
			return Color.getHSBColor((float) (rainbowState / 360.0f), 0.5f, 1f).getRGB();
	}
}
