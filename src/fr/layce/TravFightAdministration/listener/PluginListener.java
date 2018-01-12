package fr.layce.TravFightAdministration.listener;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class PluginListener implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player ply = event.getPlayer();
		
		if (ply.isOp()) {
			// Inventaire
			ItemStack custom_compass = new ItemStack(Material.COMPASS, 1);
			ItemMeta compass_m = custom_compass.getItemMeta();
			compass_m.setDisplayName("AdminInv");
			custom_compass.setItemMeta(compass_m);			
			
			if (!ply.getInventory().contains(custom_compass)) {
				ply.getInventory().addItem(custom_compass);
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player ply = event.getPlayer();
		Action act = event.getAction();
		ItemStack it = event.getItem();
		
		if (it == null) return;
		
		// AdminInv
		if (it.getType() == Material.COMPASS) {
			if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("AdminInv")) {
				if (act == Action.RIGHT_CLICK_AIR || act == Action.RIGHT_CLICK_BLOCK) {
					/* DEFINITION DES ITEMS */
					// Excaliburne
					ItemStack custom_sword = new ItemStack(Material.WOOD_SWORD, 1);
					ItemMeta sword_m = custom_sword.getItemMeta();
					sword_m.setDisplayName(ChatColor.GOLD + "ExcaliBurne");
					sword_m.setLore(Arrays.asList("Epée 'CHEATER' permettant de tuer tout le monde !",  ChatColor.LIGHT_PURPLE + "Destination: Admins"));
					sword_m.addEnchant(Enchantment.DAMAGE_ALL, 999, true);
					sword_m.addItemFlags(ItemFlag.HIDE_ENCHANTS);
					custom_sword.setItemMeta(sword_m);
					
					/* INVENTAIRE */
					Inventory inv = Bukkit.createInventory(null, 9, "Inventaire d'Administrateurs");
					inv.setItem(0, custom_sword);
					
					ply.openInventory(inv);
				}
			}
		}
	}
}
