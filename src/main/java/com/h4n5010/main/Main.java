package com.h4n5010.main;

import com.h4n5010.commands.MinecraftCommands;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public String prefix = "§aBedWars: ";
    public Integer minPlayers = 4;

    @Override
    public void onEnable() {
        initCommands();
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
}

