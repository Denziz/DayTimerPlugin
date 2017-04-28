package me.denziz.com;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		getCommand("reloaddaytimer").setExecutor(new ReloadConfigCommand(this));
		
		/*BukkitTask task = */new CheckTimeAndDay(this).runTaskTimer(this, 1150L, 1150L);
	}

	@Override
	public void onDisable() {

	}
}
