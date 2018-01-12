package fr.layce.TravFightAdministration.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.layce.TravFightAdministration.Main;
import net.md_5.bungee.api.ChatColor;

public class CMD_SeeInv implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player ply = (Player) sender;
			
			if (ply.isOp()) {
				if (args.length == 1) {
	
					Player playerTarget = Main.server.getPlayer(args[0]);
					if (playerTarget == null) {
						ply.sendMessage(Main.namePlugin() + ChatColor.RED + "Joueur '" + args[0] + "' introuvable");
					} else {
						Inventory playerInv = playerTarget.getInventory();
						((Player) sender).openInventory(playerInv);
						return true;
					}
				} else {
					ply.sendMessage(Main.namePlugin() + ChatColor.RED + "Il faut entrer un seul nom de joueur");
				}
			}
		}
		return false;
	}

}
