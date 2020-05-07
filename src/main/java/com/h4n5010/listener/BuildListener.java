package com.h4n5010.listener;

import com.h4n5010.functions.GameState;
import com.h4n5010.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class BuildListener implements Listener {
    private Main main;

    public BuildListener(Main main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onBuildBreak(BlockBreakEvent e) {
        if (GameState.getGameState() == GameState.LOBBY){
            if (e.getPlayer().getGameMode() != GameMode.CREATIVE){
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onBuildPlace(BlockPlaceEvent e) {
        if (GameState.getGameState() == GameState.LOBBY){
            if (e.getPlayer().getGameMode() != GameMode.CREATIVE){
                e.setCancelled(true);
            }
        }
    }
}
