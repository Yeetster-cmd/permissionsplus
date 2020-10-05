package me.yeetsterdev.permissionsplus;

import me.yeetsterdev.permissionsplus.commands.RankCommand;
import me.yeetsterdev.permissionsplus.events.ConnectEvents;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {
    private static Main main;

    @Override
    public void onEnable() {
        main = this;
        this.saveDefaultConfig();
        saveConfig();
        Bukkit.getPluginManager().registerEvents(new ConnectEvents(), this);
        getCommand("rank").setExecutor(new RankCommand());
        System.out.println(ChatColor.GREEN + "Permissions+ v1.0 has loaded succesfully");

    }
    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "Permissions+ v1.0 has been disaled");
    }
    public static Main getmain() {
        return main;
    }
    public ArrayList<String> getPermissions(Player player) {
        ArrayList<String> permissions = new ArrayList<>();
        if(getConfig().contains(player.getUniqueId().toString() + ".permissions")) {
            permissions = (ArrayList<String>) getConfig().getStringList(player.getUniqueId().toString() + ".permissions");
        }
        return permissions;
    }
}
