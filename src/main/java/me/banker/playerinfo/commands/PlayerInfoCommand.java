package me.banker.playerinfo.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PlayerInfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            // if the player has the permission to use this command

            if (cmd.getName().equalsIgnoreCase("playerinfo")) {
                if (sender.hasPermission("playerinfo.playerinfo")) {

                    Player player = (Player) sender;
                    // When the player dose /playerinfo <player> show the players info in a GUI that is 27 tiles
                    if (args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            Inventory inv = Bukkit.createInventory(null, 27, ChatColor.BLUE + "Info!");

                            // Player Head
                            ItemStack playerheadz = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
                            ItemMeta playerheadmeta = playerheadz.getItemMeta();
                            List<String> lore = new ArrayList<>();
                            playerheadmeta.setDisplayName(ChatColor.BLUE + target.getDisplayName());
                            playerheadmeta.setLore(java.util.Arrays.asList(ChatColor.BLUE + "UUID: " + target.getUniqueId().toString()));
                            playerheadz.setItemMeta(playerheadmeta);
                            playerheadmeta.setLore(lore);
                            inv.setItem(10, playerheadz);

                            // Player health
                            ItemStack playerhealth = new ItemStack(Material.HEART_OF_THE_SEA, 1, (short) 3);
                            ItemMeta playerhealthmeta = playerhealth.getItemMeta();
                            playerhealthmeta.setDisplayName(ChatColor.BLUE + "Health: " + target.getHealth());
                            // get the players uuid and add it to the item meta
                            playerhealth.setItemMeta(playerhealthmeta);

                            inv.setItem(11, playerhealth);

                            // Players food level
                            ItemStack playerfood = new ItemStack(Material.COOKED_BEEF, 1, (short) 3);
                            ItemMeta playerfoodmeta = playerfood.getItemMeta();
                            playerfoodmeta.setDisplayName(ChatColor.BLUE + "Food Level: " + target.getFoodLevel());
                            playerfood.setItemMeta(playerfoodmeta);
                            inv.setItem(12, playerfood);

                            //Player online
                            ItemStack playeronline = new ItemStack(Material.GREEN_WOOL, 1, (short) 3);
                            ItemMeta playeronlinemeta = playeronline.getItemMeta();
                            playeronlinemeta.setDisplayName(ChatColor.BLUE + "Online: " + target.isOnline());
                            playeronline.setItemMeta(playeronlinemeta);
                            inv.setItem(13, playeronline);

                            // Players op status
                            ItemStack playerop = new ItemStack(Material.BLACK_BED, 1, (short) 3);
                            ItemMeta playeropmeta = playerop.getItemMeta();
                            playeropmeta.setDisplayName(ChatColor.BLUE + "Op Status: " + target.isOp());
                            playerop.setItemMeta(playeropmeta);
                            inv.setItem(14, playerop);

                            // Players gamemode
                            ItemStack playergamemode = new ItemStack(Material.BEDROCK, 1, (short) 3);
                            ItemMeta playergamemodemeta = playergamemode.getItemMeta();
                            playergamemodemeta.setDisplayName(ChatColor.BLUE + "Gamemode: " + target.getGameMode().toString());
                            playergamemode.setItemMeta(playergamemodemeta);
                            inv.setItem(15, playergamemode);

                            // players IP
                            ItemStack playerip = new ItemStack(Material.RED_WOOL, 1, (short) 3);
                            ItemMeta playeripmeta = playerip.getItemMeta();
                            playeripmeta.setDisplayName(ChatColor.BLUE + "IP: " + target.getAddress());
                            playerip.setItemMeta(playeripmeta);
                            inv.setItem(16, playerip);


                            // Close button
                            ItemStack close = new ItemStack(Material.BARRIER, 1);
                            ItemMeta closemeta = close.getItemMeta();
                            closemeta.setDisplayName(ChatColor.RED + "Close");
                            close.setItemMeta(closemeta);
                            inv.setItem(0, close);

                            // Frame
                            ItemStack frame = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1, (short) 15);
                            ItemMeta framemeta = frame.getItemMeta();
                            framemeta.setDisplayName(" ");
                            frame.setItemMeta(framemeta);
                            for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26}) {
                                inv.setItem(i, frame);
                                player.openInventory(inv);
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Player not found!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                    }

                }

            }
        }
        return true;
    }

}
