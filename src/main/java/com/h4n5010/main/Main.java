package com.h4n5010.main;

import com.h4n5010.commands.MinecraftCommands;
import com.h4n5010.functions.GameState;
import com.h4n5010.listener.EntityDamageListener;
import com.h4n5010.listener.FoodLevelChangeListener;
import com.h4n5010.listener.JoinListener;
import com.h4n5010.listener.WeatherChangeListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public String prefix = "§aBedWars: ";
    public Integer minPlayers = 4;

    @Override
    public void onEnable() {
        initCommands();
        initListener();
        GameState.setGameState(GameState.LOBBY);
    }



    @Override
    public void onDisable(){

    }


    /*
    initializes all commands used in plugin
     */
    private void initCommands() {
        new MinecraftCommands(this);
    }
    /*
    initializes all listener used in plugin
     */
    private void initListener() {
        new JoinListener(this);
        new EntityDamageListener(this);
        new FoodLevelChangeListener(this);
        new WeatherChangeListener(this);
    }
}

