package fr.layce.TravFightAdministration;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.layce.TravFightAdministration.commands.CMD_Day;
import fr.layce.TravFightAdministration.commands.CMD_Gm;
import fr.layce.TravFightAdministration.commands.CMD_Kick;
import fr.layce.TravFightAdministration.commands.CMD_Night;
import fr.layce.TravFightAdministration.commands.CMD_SeeInv;
import fr.layce.TravFightAdministration.commands.CMD_ShowLog;
import fr.layce.TravFightAdministration.commands.CMD_Vanish;
import fr.layce.TravFightAdministration.listener.PluginListener;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	ConsoleCommandSender console;
	public static Server server = Bukkit.getServer();
	public static Location location;
	public static HidePlayerList hidenPlayers;

	public void onEnable() {
		console = Bukkit.getServer().getConsoleSender();
		console.sendMessage("[Admin]: Plugin Start !");

		hidenPlayers = new HidePlayerList();
		
		// Chargement des commandes
		getCommand("seeInv").setExecutor(new CMD_SeeInv());
		getCommand("kick").setExecutor(new CMD_Kick());
		getCommand("vanish").setExecutor(new CMD_Vanish());
		getCommand("showLog").setExecutor(new CMD_ShowLog());
		getCommand("day").setExecutor(new CMD_Day());
		getCommand("night").setExecutor(new CMD_Night());
		getCommand("gm").setExecutor(new CMD_Gm());

		// Listener
		Listener l = new PluginListener();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(l, this);
	}

	public void onDisable() {
		console.sendMessage("[Admin] Plugin stop.");
	}

	/* ---------------------------------------------- */
	public static String namePlugin() {
		return ChatColor.YELLOW + "[" + ChatColor.GRAY + "Admin" + ChatColor.YELLOW + "] " + ChatColor.RESET;
	}
}
