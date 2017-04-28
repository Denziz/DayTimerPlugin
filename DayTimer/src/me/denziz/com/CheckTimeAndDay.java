package me.denziz.com;

import java.util.Calendar;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

public class CheckTimeAndDay extends BukkitRunnable {

	private int day;
	private String configDays;
	
	Main plugin;
	public CheckTimeAndDay(Main pl) {
		plugin = pl;
	}

	@Override
	public void run() {
		getDayInConfigurationFile();

		Calendar myDate = Calendar.getInstance();

		int dayOfWeek = myDate.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == day) {
			if (myDate.get(Calendar.HOUR_OF_DAY) == plugin.getConfig().getInt("Hour")) {
				if (myDate.get(Calendar.MINUTE) == plugin.getConfig().getInt("Minute")) {

					CommandSender cmd = Bukkit.getConsoleSender();
					plugin.getServer().dispatchCommand(cmd, plugin.getConfig().getString("Command"));
					System.out.println("[" + plugin.getName() + "] executed command: " + plugin.getConfig().getString("Command"));
				}
			}
		}
	}

	public void getDayInConfigurationFile() {
		configDays = plugin.getConfig().getString("Day");

		switch (configDays.toLowerCase()) {
		case "monday":
			day = Calendar.MONDAY;
			break;
		case "tuesday":
			day = Calendar.TUESDAY;
			break;
		case "wednesday":
			day = Calendar.WEDNESDAY;
			break;
		case "thursday":
			day = Calendar.THURSDAY;
			break;
		case "friday":
			day = Calendar.FRIDAY;
			break;
		case "saturday":
			day = Calendar.SATURDAY;
			break;
		case "sunday":
			day = Calendar.SUNDAY;
			break;
		default:
			Bukkit.getConsoleSender().sendMessage("You must provide a day in the config file.");
			break;
		}
	}
}
