package com.h4n5010.manager;

import com.h4n5010.functions.GameState;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameManager {

    public static HashMap<String, List<Player>> playersInTeam = new HashMap<>();

    /**
     *
     */
    public static void start(){
        GameState.setGameState(GameState.INGAME);
    }

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
    }


    public static List<Player> getTeamPlayers(String team){
        return playersInTeam.get(team);
    }

}
