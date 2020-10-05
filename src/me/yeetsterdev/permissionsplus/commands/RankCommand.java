package me.yeetsterdev.permissionsplus.commands;

import me.yeetsterdev.permissionsplus.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class RankCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 3) {
            if(Bukkit.getPlayer(strings[0]) == null){
                commandSender.sendMessage("That User is not Online");
                return false;
            }
            Player player = Bukkit.getPlayer(strings[0]);
            if(strings[1].equalsIgnoreCase("add")) {
                assert player != null;
                if (!Main.getmain().getPermissions(player).contains(strings[2])) {
                    ArrayList<String> perm = Main.getmain().getPermissions(player);
                    perm.add(strings[2]);
                    Main.getmain().getConfig().set(player.getUniqueId().toString() + ".permissions" , perm);
                    Main.getmain().saveConfig();
                    commandSender.sendMessage(player.getDisplayName() + " now has " + strings[2]);
                }else {
                    commandSender.sendMessage("That User already has that permission!");
                }
            }else {
                if(strings[1].equalsIgnoreCase("remove")) {
                    assert player != null;
                    if(Main.getmain().getPermissions(player).contains(strings[2])){
                        ArrayList<String> perm = Main.getmain().getPermissions(player);
                        perm.remove(strings[2]);
                        Main.getmain().getConfig().set(player.getUniqueId().toString() + ".permissions" , perm);
                        Main.getmain().saveConfig();
                        commandSender.sendMessage(player.getDisplayName() + " no longer has " + strings[2]);
                    }else {
                        commandSender.sendMessage("That User doesn't have that permission already!");
                    }
                }
            }
        } else {
            commandSender.sendMessage("/rank <player> <add|remove> <permission>");
        }
        return false;
    }
}
