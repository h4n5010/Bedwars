package com.h4n5010.listener;

import com.h4n5010.functions.GameState;
import com.h4n5010.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropListener implements Listener {

    private Main main;

    public ItemDropListener(Main main){
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onInvItemDrop(PlayerDropItemEvent e){
        if (GameState.getGameState() == GameState.LOBBY) {
            e.setCancelled(true);
        }
    }
}
