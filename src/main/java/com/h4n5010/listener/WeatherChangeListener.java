package com.h4n5010.listener;

import com.h4n5010.functions.GameState;
import com.h4n5010.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChangeListener implements Listener {

    private Main main;

    public WeatherChangeListener(Main main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent e) {

        e.setCancelled(true);
        e.getWorld().setStorm(false);
        e.getWorld().setWeatherDuration(0);
        e.getWorld().setThundering(false);

    }
}
