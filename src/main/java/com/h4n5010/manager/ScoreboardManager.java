package com.h4n5010.manager;

import com.h4n5010.functions.ScoreboardTeams;
import com.h4n5010.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ScoreboardManager {

    private Main main;
    public Scoreboard scoreboard;
    public HashMap<String, Team> teams = new HashMap<>();

    /**
     *
     * @param main
     */
    public ScoreboardManager(Main main){
        this.main = main;
        generate();
    }

    public void generate() {
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("dummy", "teams");

        scoreboard.registerNewTeam("001default").setPrefix("§7");

        for(String teamnumber : main.getConfig().getConfigurationSection("location.spawn").getKeys(false)){
            Team team = scoreboard.registerNewTeam("00000" + teamnumber);
            team.setPrefix("§bTeam #0" + teamnumber + " | §7");
            team.setAllowFriendlyFire(false);
            teams.put(teamnumber, team);

            ScoreboardTeams.playersInTeam.put(teamnumber, new ArrayList<>());
        }


    }

    public void show(Player p){
        p.setScoreboard(scoreboard);
    }

    public void setTeam(String playerName, String teamName){
        teams.get(teamName).addEntry(playerName);
        Bukkit.getOnlinePlayers().forEach(p->p.setScoreboard(scoreboard));
    }
}
