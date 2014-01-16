package me.qdog83.lorepvp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Pvp implements CommandExecutor{


	public boolean onCommand(CommandSender sender, Command cmd, String tag,
			String[] args) {
		Player player = (Player) sender;
		if(Main.usedkit.contains(player.getName())){
			player.sendMessage(ChatColor.RED + "You have already used a kit this life!");
		}else{
			Main.usedkit.add(player.getName());
			player.getInventory().clear();
			player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
			player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
			for(int i = 0; i < 30; i++){
				player.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			}
			player.sendMessage(ChatColor.AQUA + "Recieved the PvP kit!");
		}
		

		return false;
	}

}
