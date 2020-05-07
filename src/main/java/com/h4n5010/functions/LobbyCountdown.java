package com.h4n5010.functions;

import com.h4n5010.main.Main;
import com.h4n5010.manager.GameManager;
import org.bukkit.Bukkit;

public class LobbyCountdown {

    private static Main main;
    private static boolean isStarted = false;
    static Integer count = 60;
    static Integer sched = 0;

    /**
     * starts the count down for the game
     * @param force if true starts countdown without enough players online
     */

    public static void start(boolean force){
        if (GameState.getGameState() != GameState.LOBBY) return;
        if (force || Bukkit.getOnlinePlayers().size() >= Integer.parseInt((String) main.getConfig().get("game.teamsize"))){
            if(!isStarted){
                if (force) {
                    count = 5;
                }
                sched = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {
                    @Override
                    public void run() {
                        if (count <= 60 && count != 0){
                            Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(Main.getPlugin(Main.class).prefix +
                                    "§aGame starts in §8" + count + " seconds!"));
                            count--;
                        } else if (count == 0){
                            GameManager.start();
                            Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(Main.getPlugin(Main.class).prefix +
                                    "§aGame starts NOW!"));
                            Bukkit.getScheduler().cancelTask(sched);
                        }
                    }
                }, 20, 20);
            }
        }
    }
}
