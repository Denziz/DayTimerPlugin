package me.denziz.com;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadConfigCommand implements CommandExecutor{

	Main plugin;
	public ReloadConfigCommand(Main pl) {
		plugin = pl;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("reloaddaytimer")) {
			if (sender.isOp() || sender.hasPermission("daytimer.reload")) {
				plugin.reloadConfig();
				sender.sendMessage(ChatColor.GREEN + "Successfully reloaded the config for " + plugin.getName());
			} else {
				sender.sendMessage(ChatColor.RED + "You do not have enough permissions to use this command.");
				return true;
			}
		}
		return true;
	}

}
