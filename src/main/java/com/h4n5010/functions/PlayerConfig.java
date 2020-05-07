package com.h4n5010.functions;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class PlayerConfig {

    public static void initialSetup(Player player){
        player.setGameMode(GameMode.SURVIVAL);
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.updateInventory();
        player.setHealth(20);
        player.setExp(0);
        player.setFoodLevel(20);
        player.setMaxHealth(20);
        player.setAllowFlight(false);
        player.setLevel(0);
    }
}
