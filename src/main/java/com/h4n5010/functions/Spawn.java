package com.h4n5010.functions;

import com.h4n5010.main.Main;
import org.bukkit.Location;

public class Spawn {

    private static Integer id = 0;


    /**
     *
     * @param location
     * @param main
     * @return
     */
    public static Integer setSpawn(Location location, Main main){
        main.getConfig().set("location.spawn" + id, location);
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
}
