package fr.layce.TravFightAdministration.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CMD_Night implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player ply = (Player) sender;
			
			if (ply.isOp()) {
				if (args.length == 0) {
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "time set 13000");
				} else {
					ply.sendMessage(ChatColor.YELLOW + "[" + ChatColor.GRAY + "Admin" + ChatColor.YELLOW +"] "
							+ ChatColor.RED + "Aucun argument attendu");
				}
			}
		}
		return true;
	}
}