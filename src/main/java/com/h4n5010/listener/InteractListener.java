package com.h4n5010.listener;

import com.h4n5010.functions.GameState;
import com.h4n5010.functions.PlayerConfig;
import com.h4n5010.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

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
                if (e.getItem().getType() == Material.BEDROCK){
                    Set<String> teams = main.getConfig().getConfigurationSection("location.spawn").getKeys(false);
                    int size = 0;
                    if (teams.size() <= 9){
                        size = 9;
                    }
                    Inventory inv = Bukkit.createInventory(null, size, "§choose your team");
                }
            }
        }
    }
}
