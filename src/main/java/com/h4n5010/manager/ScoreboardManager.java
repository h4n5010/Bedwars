package com.h4n5010.manager;

import com.h4n5010.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;

public class ScoreboardManager {

    private Main main;
    private Scoreboard scoreboard;
    HashMap<String, Team> teams = new HashMap<>();

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
        for(String teamnumber : main.getConfig().getConfigurationSection("location.spawn").getKeys(false)){
            Team team = scoreboard.registerNewTeam("00000" + teamnumber);
            team.setPrefix("§b #" + teamnumber + " | §7");
            team.setAllowFriendlyFire(false);
            teams.put(teamnumber, team);
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
