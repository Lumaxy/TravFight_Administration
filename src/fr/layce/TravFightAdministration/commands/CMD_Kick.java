package fr.layce.TravFightAdministration.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.layce.TravFightAdministration.Main;
import net.md_5.bungee.api.ChatColor;

public class CMD_Kick implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player ply = (Player) sender;
			
			if (ply.isOp()) {
				if (args.length > 0) {
					Player playerTarget = Main.server.getPlayer(args[0]);
	
					if (playerTarget == null) {
						ply.sendMessage(Main.namePlugin() + ChatColor.RED + "Joueur '" + args[0] + "' introuvable");
					} else {
						String kickReason = "";
						if (args.length > 1) {
							for (int i = 1; i < args.length; i++) {
								kickReason += args[i] + " ";
							}
						} else {
							// Message par defaut
							kickReason = "On vous a exclu du serveur";
						}
						playerTarget.kickPlayer(kickReason);
						return true;
					}
				} else {
					ply.sendMessage(Main.namePlugin() + ChatColor.RED + "Pas assez d'arguments");
					// usage
				}
			}
		}

		return true;
	}
}
