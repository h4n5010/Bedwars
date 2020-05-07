package com.h4n5010.listener;

import com.h4n5010.functions.GameState;
import com.h4n5010.functions.PlayerConfig;
import com.h4n5010.main.Main;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private Main main;

    public JoinListener(Main main){
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if (GameState.getGameState() == GameState.LOBBY) {
            e.setJoinMessage(main.prefix + "§a" + e.getPlayer().getName() + " §7has joined the game!");
            PlayerConfig.initialSetup(e.getPlayer());
            try {
                e.getPlayer().teleport((Location) main.getConfig().get("location.lobby"));
            } catch (NullPointerException nullex) {
                e.getPlayer().sendMessage(main.prefix + "§cThe plugin is not completely initialized!!");
            }
        }
    }
}
