package com.h4n5010.main;

import com.h4n5010.commands.MinecraftCommands;
import com.h4n5010.functions.GameState;
import com.h4n5010.listener.*;
import com.h4n5010.manager.ScoreboardManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Score;

public class Main extends JavaPlugin {

    public String prefix = "§aBedWars: ";
    public ScoreboardManager scoreboardManager;

    @Override
    public void onEnable() {
        initCommands();
        initManager();
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
    initializes all commands used in plugin
     */
    private void initManager() {
        scoreboardManager = new ScoreboardManager(this);
    }
    /*
    initializes all listener used in plugin
     */
    private void initListener() {
        new JoinListener(this);
        new EntityDamageListener(this);
        new FoodLevelChangeListener(this);
        new InventoryClickListener(this);
        new WeatherChangeListener(this);
        new BuildListener(this);
        new InteractListener(this);
        new ItemDropListener(this);
    }
}

