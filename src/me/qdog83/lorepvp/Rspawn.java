package me.qdog83.lorepvp;

import org.bukkit.Bukkit;
import org.bukkit


public void onDeath(EntityDamageEvent event) {
        Entity player = event.getEntity();
        if (player instanceof Player) {
            Player p = (Player) player;
            Integer damage = event.getDamage();
            Integer pHealth = p.getHealth();
            if (pHealth - damage <= 0) {
                event.setCancelled(true);
                Location loc = new Location(player.getWorld(), 1497.40776, 75,
                        -316.91667);
                p.teleport(loc);
                p.getInventory().clear();
                p.setHealth(10);
                p.sendMessage(ChatColor.RED + "You have died.");
                p.setFoodLevel(10);
            }
 
        }
    }
