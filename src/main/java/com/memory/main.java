package com.memory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        for (Player player : getServer().getOnlinePlayers()){ //подчёркивает getPlugin
            player.sendMessage(ChatColor.AQUA + "Версия плагина: " + getDescription().getVersion());
        }
    }
}
