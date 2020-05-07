package com.h4n5010.listener;

import com.h4n5010.functions.GameState;
import com.h4n5010.main.Main;
import com.h4n5010.manager.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.Objects;

public class InventoryClickListener implements Listener {

    private Main main;

    public InventoryClickListener(Main main){
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        if (GameState.getGameState() == GameState.LOBBY){
            if(e.getCurrentItem() != null){
                String team = e.getCurrentItem().getItemMeta().getDisplayName().substring(9);
                GameManager.setPlayerTeam((Player) e.getWhoClicked(), team);
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(main.prefix + "§a You are now in §bTeam #0" + team );
            }
            e.setCancelled(true);

        }
    }

    public static String getInventoryName(InventoryClickEvent e) {
        try {
            Object nextInv = e.getView();

            return (String) nextInv.getClass().getMethod("getTitle").invoke(nextInv);
        } catch (Exception exc) {
            exc.printStackTrace();
            return null;
        }
    }
}
