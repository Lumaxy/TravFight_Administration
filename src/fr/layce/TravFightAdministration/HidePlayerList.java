package fr.layce.TravFightAdministration;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class HidePlayerList {
	private ArrayList<Player> hidenPlayers;
	
	public HidePlayerList() {
		this.hidenPlayers = new ArrayList<Player>();
	}
	
	public boolean setHiden(Player ply) {				
		if (this.hidenPlayers.contains(ply)) {
			hidenPlayers.remove(ply);
			
			for (Player pl: Bukkit.getOnlinePlayers()) {
				pl.showPlayer(ply);
			}
			
			ply.setPlayerListName(ChatColor.RED + ply.getName());
			
			return false;
		} else {
			hidenPlayers.add(ply);
			for (Player pl: Bukkit.getOnlinePlayers()) {
				if (!pl.isOp()) {
					pl.hidePlayer(ply);
				}
			}
			ply.setPlayerListName(ChatColor.GREEN + ply.getName());
			
			return true;
		}
	}
	
	// Supprime le joueur de la liste quand il quitte le serveur
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player ply = event.getPlayer();
		
		this.hidenPlayers.remove(ply);
	}
}
