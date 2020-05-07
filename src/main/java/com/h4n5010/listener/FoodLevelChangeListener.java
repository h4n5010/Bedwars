package com.h4n5010.listener;

import com.h4n5010.functions.GameState;
import com.h4n5010.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeListener implements Listener {

    private Main main;

    public FoodLevelChangeListener(Main main){
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onFood(FoodLevelChangeEvent e) {
        if(GameState.getGameState() == GameState.LOBBY) e.setCancelled(true);
    }
}
