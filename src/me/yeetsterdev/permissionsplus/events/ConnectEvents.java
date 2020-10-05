package me.yeetsterdev.permissionsplus.events;


import me.yeetsterdev.permissionsplus.permissions.CustomPermissionBase;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftHumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.lang.reflect.Field;

public class ConnectEvents implements Listener {
    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        try {
            Field f = CraftHumanEntity.class.getDeclaredField("perm");
            f.setAccessible(true);
            f.set(e.getPlayer(), new CustomPermissionBase(e.getPlayer()));
            f.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
        }
    }
}
