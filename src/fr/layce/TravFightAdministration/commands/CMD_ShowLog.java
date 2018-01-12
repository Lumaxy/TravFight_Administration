package fr.layce.TravFightAdministration.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.layce.TravFightAdministration.Main;

public class CMD_ShowLog implements CommandExecutor {
	private String str = "";
	private Player ply;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			ply = (Player) sender;
			
			if (ply.isOp()) {
				if (args.length == 0) {
					Thread th = new Thread() {
						public void run() {
							str = loadLog();
							str = str.replace("[Server thread/INFO]", ChatColor.GREEN + "INFO" + ChatColor.WHITE);
							ply.sendMessage(Main.namePlugin() + str);
						}
					};
					th.start();
				} else {
					ply.sendMessage(ChatColor.YELLOW + "[" + ChatColor.GRAY + "Admin" + ChatColor.YELLOW +"] "
							+ ChatColor.RED + "Aucun argument attendu");
				}
			}
		}
		return true;
	}

	public static String loadLog() {
		String logStr = "";

		File log = new File("logs/latest.log");

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(log);
			int carac;
			String tmp = "";
			int cpt = 0;
			fis.skip(log.length() - 6620);
			while ((carac = fis.read()) != -1 && cpt <= 6620) {
				tmp += (char) carac;
				cpt++;
			}
			logStr = tmp.substring(tmp.length() - 6620, tmp.length());
			System.out.println("LoadingLogs :ok.");
		} catch (FileNotFoundException e) {
			System.out.println("Pas de fichier de sauvegarde.");
			// FileOutputStream fos;
			try {
				//
				// fos = new FileOutputStream(locationF);

				log.createNewFile();
				System.out.println("Fichier creer.");

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return logStr;
	}
}
