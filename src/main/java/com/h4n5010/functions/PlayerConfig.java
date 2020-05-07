package com.h4n5010.functions;

import com.h4n5010.builder.ItemBuilder;
import com.h4n5010.main.Main;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
        ItemStack stack = new ItemBuilder(Material.BEDROCK, 1).setName("choose your team").toItemStack();
        player.getInventory().setItem(0, stack);
    }

}
