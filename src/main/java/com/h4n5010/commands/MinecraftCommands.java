package com.h4n5010.commands;

import com.h4n5010.functions.LobbyCountdown;
import com.h4n5010.functions.Spawn;
import com.h4n5010.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
 * Handles all commands from the user
 */

public class MinecraftCommands implements CommandExecutor {

    private Main main;

    public MinecraftCommands(Main main){
        this.main = main;
        Bukkit.getPluginCommand("bedwars").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (args.length == 1 && args[0].equalsIgnoreCase("setLobby")) {
            main.getConfig().set("location.lobby", player.getLocation());
            main.saveConfig();
            player.sendMessage(main.prefix + "§aYou set the lobby!");
        } else if (args.length == 1 && args[0].equalsIgnoreCase("setSpawn")){
            Integer id = Spawn.setSpawn(player.getLocation(), main);
            player.sendMessage(main.prefix + "§aYou set the spawn! §8[ID=" + id + "]");
        }
        else if (args.length == 1 && args[0].equalsIgnoreCase("setSpectator")){
            Spawn.setSpectatorSpawn(player.getLocation(), main);
            player.sendMessage(main.prefix + "§aYou set the Spectator spawn!");
        }
        else if (args.length == 2 && args[0].equalsIgnoreCase("setTeamSize")){
            main.getConfig().set("config.teamsize", Integer.parseInt(args[1]));
            main.saveConfig();
            player.sendMessage(main.prefix + "§aYou set the team size to " + String.valueOf(args[1]));
        }
        else if (args.length == 2 && args[0].equalsIgnoreCase("startGame")){
            boolean force = args[1].equalsIgnoreCase("1");
            player.sendMessage(main.prefix + "§aYou set the start to");
            LobbyCountdown.start(true);
        } else {
            showHelp(player);
        }

        return true;
    }

    private void showHelp(Player player) {
        // TODO implement help method
    }
}
