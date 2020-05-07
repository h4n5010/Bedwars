package com.h4n5010.listener;

import com.h4n5010.functions.GameState;
import com.h4n5010.functions.PlayerConfig;
import com.h4n5010.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EntityDamageListener implements Listener {

    private Main main;

    public EntityDamageListener(Main main){
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onDamge(EntityDamageEvent e){
        if (GameState.getGameState() == GameState.LOBBY) {
            if (e.getEntity() instanceof Player){
                if (e.getCause() == EntityDamageEvent.DamageCause.VOID){
                    e.getEntity().teleport((Location) main.getConfig().get("location.lobby"));
                } else {
                    e.setCancelled(true);
                }
            }
        }
    }
}
