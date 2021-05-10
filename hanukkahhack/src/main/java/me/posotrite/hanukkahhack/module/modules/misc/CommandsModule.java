package me.posotrite.hanukkahhack.module.modules.misc;

import me.posotrite.hanukkahhack.Hanukkah;
import me.posotrite.hanukkahhack.command.Command;
import me.posotrite.hanukkahhack.command.Commands;
import me.posotrite.hanukkahhack.module.Category;
import me.posotrite.hanukkahhack.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/* Get commands from chat & find associated FFP command */

@SideOnly(Side.CLIENT)
public class CommandsModule extends Module {

  private static String ESCAPE_CHARACTER = "`";

  private Commands commands;

  public CommandsModule() {
    super("Commands", "Enable Command System", Category.MISC);
    this.setKey(0);
    this.commands = new Commands();
  }

  public Command getCommand(String name) {
    return this.commands.getCommand(name);
  }

  protected void enable() {
    MinecraftForge.EVENT_BUS.register(this);
  }

  protected void disable() {
    MinecraftForge.EVENT_BUS.unregister(this);
  }

  public void onDisconnect() {
    for(Command c : this.commands.getCommands()) {
      c.onDisconnect();
    }
  }

  public boolean displayInGui() {
    return false;
  }

  @SubscribeEvent
  public void onChat(ClientChatEvent event) {
    String message = event.getMessage();
    if(message.startsWith(CommandsModule.ESCAPE_CHARACTER)) {
      String[] args = message.substring(1).split("[ ]+");
      if(args.length <= 0) return;
      Command cmd = this.commands.getCommand(args[0]);
      if(cmd != null) {
        String ret = cmd.execute(args);
        if(ret != null) Hanukkah.printMessage(ret);
        event.setCanceled(true);
        Minecraft.getMinecraft().ingameGUI.getChatGUI().addToSentMessages(message);
      }
    }
  }

  public boolean defaultState() {
    return true;
  }
}
