package com.h4n5010.listener;

import com.h4n5010.builder.ItemBuilder;
import com.h4n5010.functions.GameState;
import com.h4n5010.functions.PlayerConfig;
import com.h4n5010.main.Main;
import com.h4n5010.manager.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class InteractListener implements Listener {

    private Main main;

    public InteractListener(Main main){
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if (GameState.getGameState() == GameState.LOBBY) {
            if (e.getItem() != null){
                if (e.getItem().getType() == Material.DIAMOND_SWORD){
                    Set<String> teams = main.getConfig().getConfigurationSection("location.spawn").getKeys(false);
                    int size = 0;
                    if (teams.size() <= 9){
                        size = 9;
                    }
                    Inventory inv = Bukkit.createInventory(null, size, "§ choose your team");

                    for(String s : teams){
                        try{
                            ItemBuilder itemBuilder = new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayName("§bTeam #0" + s);

                            itemBuilder.setLore("");

                            for (int i = 0; i < main.getConfig().getInt("config.teamsize"); i++){
                               try {
                                    itemBuilder.setLore("§a" + GameManager.playersInTeam.get(s).get(i).getName());
                                } catch (Exception e2){
                                    itemBuilder.setLore("§8<nicht belegt>");
                                }
                            }

                            inv.setItem(Integer.parseInt(s),
                                    itemBuilder.build());
                        } catch (NullPointerException nullex){
                            e.getPlayer().sendMessage(main.prefix + "§cAn Error occured code 1");
                        }
                    }

                    e.getPlayer().openInventory(inv);

                }
            }
        }
    }
}
