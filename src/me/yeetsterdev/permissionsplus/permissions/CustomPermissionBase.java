package me.yeetsterdev.permissionsplus.permissions;

import me.yeetsterdev.permissionsplus.Main;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissibleBase;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomPermissionBase extends PermissibleBase {
    private Player player;

    public CustomPermissionBase(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public boolean hasPermission(String inName) {
        ArrayList<String> permissions = Main.getmain().getPermissions(player);
        if(Arrays.asList("bukkit.broadcast.user" , "bukkit.broadcast" , "bukkit.command.version").contains(inName)) {
            return true;
        }
        if(permissions.contains("-" + inName)){
            return false;
        }
        if(permissions.contains("*") || player.isOp()){
            return true;
        }
        return permissions.contains(inName);
    }
}
