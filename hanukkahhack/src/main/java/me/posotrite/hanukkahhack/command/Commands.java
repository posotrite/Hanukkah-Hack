package me.posotrite.hanukkahhack.command;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@SideOnly(Side.CLIENT)
public class Commands {
  private Map<String, Command> commands;

  

  public Commands() {
    this.commands = new HashMap<String, Command>();
    this.registerCommand(new VClipCommand());
  }

  public void registerCommand(Command cmd) {
    this.commands.put(cmd.getName(), cmd);
  }

  public Command getCommand(String name) {
    return this.commands.get(name);
  }

  public Collection<Command> getCommands() {
    return this.commands.values();
  }
}
