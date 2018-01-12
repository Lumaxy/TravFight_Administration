package fr.layce.TravFightAdministration.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.layce.TravFightAdministration.Main;
import net.md_5.bungee.api.ChatColor;

public class CMD_Vanish implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (sender instanceof Player) {
			Player ply = (Player)sender;
			
			if (ply.isOp()) {
				if (args.length == 0) {
					if (Main.hidenPlayers.setHiden(ply)) {
						ply.sendMessage(ChatColor.YELLOW + "[" + ChatColor.GRAY + "Admin" + ChatColor.YELLOW + "]" 
								+ ChatColor.WHITE + "Vous êtes en mod Vanish");
					} else {
						ply.sendMessage(ChatColor.YELLOW + "[" + ChatColor.GRAY + "Admin" + ChatColor.YELLOW + "]" 
								+ ChatColor.WHITE + "Vous êtes en mod visible");
					}
				} else {
					ply.sendMessage(ChatColor.YELLOW + "[" + ChatColor.GRAY + "Admin" + ChatColor.YELLOW +"] "
							+ ChatColor.RED + "Aucun argument attendu");
				}
			}
		}
		
		return true;
	}

}
