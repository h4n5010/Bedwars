package com.h4n5010.functions;

import com.h4n5010.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Spawn {

    private static Integer id = 0;


    /**
     *
     * @param location
     * @param main
     * @return
     */
    public static Integer setSpawn(Location location, Main main){
        main.getConfig().set("location.spawn." + id, location);
        main.saveConfig();
        return id++;
    }

    /**
     *
     * @param location
     * @param main
     */
    public static void setSpectatorSpawn(Location location, Main main){
        main.getConfig().set("location.specspawn", location);
        main.saveConfig();
    }

    public static void teleportAll(){
        for (Player all : Bukkit.getOnlinePlayers()){
            System.out.println("TEAM: " + Main.getPlugin(Main.class).getConfig().get("location.spawn." + ScoreboardTeams.getPlayerTeam(all)));
            all.teleport((Location) Main.getPlugin(Main.class).getConfig().get("location.spawn." + ScoreboardTeams.getPlayerTeam(all)));
        }
    }
}
