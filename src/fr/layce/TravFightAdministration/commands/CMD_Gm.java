package fr.layce.TravFightAdministration.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.layce.TravFightAdministration.Main;
import net.md_5.bungee.api.ChatColor;

public class CMD_Gm implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player ply = (Player) sender;
			
			if (ply.isOp()){
				if (args.length == 1) {
					if (Integer.valueOf(args[0]) >= 0 && Integer.valueOf(args[0]) <= 3) {
						String str_mod = "";
						switch(Integer.valueOf(args[0])){
							case 0:
								str_mod = "Survie";
								break;
							case 1:
								str_mod = "Creative";
								break;
							case 2:
								str_mod = "Aventure";
								break;
							case 3:
								str_mod = "Spectateur";
								break;
						}
						
						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gamemode " + args[0] + " " + ply.getName());
						
						ply.sendMessage(Main.namePlugin() + ChatColor.WHITE + "Vous etes passé en mode " + ChatColor.GREEN + str_mod);
					} else {
						ply.sendMessage(Main.namePlugin() + ChatColor.RED + "Vérifiez vos arguments");
					}
				}
			}
		}
		
		return true;
	}

}
