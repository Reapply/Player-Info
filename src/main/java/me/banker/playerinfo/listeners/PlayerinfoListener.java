package me.banker.playerinfo.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerinfoListener implements Listener {
    @EventHandler
    // Make the gui "inv" not clickable
    public void playerInvenetoryClick(org.bukkit.event.inventory.InventoryClickEvent event) {
        Player target = Bukkit.getPlayer(event.getWhoClicked().getName());

        if (ChatColor.translateAlternateColorCodes('&', event.getView().getTitle()).equals(ChatColor.BLUE + "Info!")
                && event.getCurrentItem() != null) {
            event.setCancelled(true);
            switch (event.getRawSlot()) {
                // Check if its slot 0 and if they click it close the gui
                case 0:
                    target.closeInventory();
                    break;
            }
        }
    }
}
