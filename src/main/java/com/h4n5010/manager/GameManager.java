package com.h4n5010.manager;

import com.h4n5010.functions.GameState;
import com.h4n5010.functions.ScoreboardTeams;
import com.h4n5010.functions.Spawn;
import com.h4n5010.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameManager {

    /**
     *
     */
    public static void start(){
        GameState.setGameState(GameState.INGAME);
        Spawn.teleportAll();
    }



}
