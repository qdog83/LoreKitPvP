package me.qdog83.lorepvp;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class kitgui implements CommandExecutor{


	public boolean onCommand(CommandSender sender, Command cmd, String tag,
			String[] args) {
		Player player = (Player) sender;
		//Define Items
		ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta pvpm = pvp.getItemMeta();
		pvpm.setDisplayName(ChatColor.GREEN + "PvP Kit");
		pvpm.setLore(Arrays.asList(ChatColor.RED + " " , ChatColor.RED + "Right click this to recieve the PvP Kit!" , ChatColor.RED + "Comes with a diamond sword and full iron armor!"));
		pvp.setItemMeta(pvpm);
		ItemStack archer = new ItemStack(Material.BOW, 1);
		ItemMeta archerm = archer.getItemMeta();
		archerm.setDisplayName(ChatColor.GREEN + "Archer Kit");
		archerm.setLore(Arrays.asList(ChatColor.RED + " " , ChatColor.RED + "Right click this to recieve the Archer Kit!", ChatColor.RED + "Comes with a stone sword and a enchanted bow!"));
		archer.setItemMeta(archerm);
		
		//Add items
		player.openInventory(Main.KitGUI);
		Main.KitGUI.clear();
		Main.KitGUI.addItem(pvp);
		Main.KitGUI.addItem(archer);

		
		return false;
	}

}
