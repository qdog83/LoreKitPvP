package me.qdog83.lorepvp;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	public static Inventory KitGUI;
	public static List<String> usedkit = new ArrayList<String>();

	public void onEnable(){
		System.out.println("LoreKitPvP v 1.0 has been enabled!");
	    getCommand("kitgui").setExecutor(new kitgui ());
	    getCommand("pvp").setExecutor(new Pvp());
	    getCommand("archer").setExecutor(new archer());
		KitGUI = Bukkit.createInventory(null, 45, "Kits");
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	public void onDisable(){
		System.out.println("LoreKitPvP v 1.0 has been enabled!");
	}
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player player = (Player) e.getWhoClicked();
		if(e.getInventory().getTitle().equals("Kits")){
			if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD){
				player.performCommand("pvp");
				e.setCancelled(true);
				player.closeInventory();
			}if(e.getCurrentItem().getType() == Material.BOW){
				player.performCommand("archer");
				e.setCancelled(true);
				player.closeInventory();
			}
		}
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player player = e.getEntity();
		if(usedkit.contains(player.getName())){
			player.sendMessage(ChatColor.DARK_GRAY + "Kit usage reset.");
			usedkit.remove(player.getName());
		}
		e.getDrops().removeAll(e.getDrops());
	}
	@EventHandler
	public void onDropEvent(final PlayerDropItemEvent e){
		if(e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD 
				|| e.getItemDrop().getItemStack().getType() == Material.GOLD_SWORD
				|| e.getItemDrop().getItemStack().getType() == Material.IRON_SWORD
				|| e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD
				|| e.getItemDrop().getItemStack().getType() == Material.WOOD_SWORD){
			Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(this, new Runnable() {
				
				
				public void run() {
					e.getItemDrop().remove();
					
				}
			}, 400);
		}else{
			Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(this, new Runnable() {
				
				
				public void run() {
					e.getItemDrop().remove();
					
				}
			}, 60);
		}
	}
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e){
		if(e.getItem().getItemStack().getType() == Material.DIAMOND_SWORD 
				|| e.getItem().getItemStack().getType() == Material.GOLD_SWORD
				|| e.getItem().getItemStack().getType() == Material.IRON_SWORD
				|| e.getItem().getItemStack().getType() == Material.STONE_SWORD
				|| e.getItem().getItemStack().getType() == Material.WOOD_SWORD){
			
		}else{
			e.getItem().remove();
			e.setCancelled(true); 
		}
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player player = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(e.getItem().getType().equals(Material.MUSHROOM_SOUP)){
				if(player.getHealth() == 20){
					
				}else if(player.getHealth() >= 13){
					player.setHealth(20);
					player.getItemInHand().setType(Material.BOWL);
				}else{
					player.setHealth(player.getHealth() + 7);
					player.getItemInHand().setType(Material.BOWL);

				}
			}
		}
	}
}
