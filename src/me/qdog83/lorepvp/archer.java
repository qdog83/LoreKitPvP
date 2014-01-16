package me.qdog83.lorepvp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class archer implements CommandExecutor{

	
	public boolean onCommand(CommandSender sender, Command cmd, String tag,
			String[] args) {
		Player player = (Player) sender;
		if(Main.usedkit.contains(player.getName())){
			player.sendMessage(ChatColor.RED + "You have already used a kit this life!");
		}else{
			ItemStack bow = new ItemStack(Material.BOW, 1);
			bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
			bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);

			Main.usedkit.add(player.getName());
			player.getInventory().clear();
			player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
			player.getInventory().addItem(bow);
			player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
			player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
			for(int i = 0; i < 30; i++){
				player.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 1));
			}
			player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
			player.sendMessage(ChatColor.AQUA + "Recieved the PvP kit!");
		}
		return false;
	}

}
