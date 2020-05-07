package com.h4n5010.functions;

import com.h4n5010.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreboardTeams {

    public static HashMap<String, List<Player>> playersInTeam = new HashMap<>();

    /**
     *
     * @param player
     * @param team
     */
    public static void setPlayerTeam(Player player, String team){
        List<Player> list = new ArrayList<>();

        for (String s : playersInTeam.keySet()){
            if(playersInTeam.get(s).contains(player)){
                playersInTeam.remove(player);
            }
        }

        if(playersInTeam.containsKey(team)){
            list = playersInTeam.get(team);
        }
        list.add(player);
        playersInTeam.put(team, list);

        Main.getPlugin(Main.class).scoreboardManager.setTeam(player.getDisplayName(), team);
    }


    /**
     *
     * @param team
     * @return
     */
    public static List<Player> getTeamPlayers(String team){
        return playersInTeam.get(team);
    }


    /**
     *
     * @param player
     * @return
     */
    public static String getPlayerTeam(Player player){
        for(String team : playersInTeam.keySet()){
            if (playersInTeam.get(team).contains(player)){
                return team;
            }
        }
        return null;
    }
}
