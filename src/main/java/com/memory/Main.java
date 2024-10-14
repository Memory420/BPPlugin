package com.memory;

import com.memory.Utils.BPLoader;
import com.memory.Utils.BPMenu;
import com.memory.commands.BPOpenMenu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    private BattlePass battlePass;

    @Override
    public void onEnable() {
        this.battlePass = BPLoader.loadFromFile();
        this.getCommand("battlepass").setExecutor(new BPOpenMenu(battlePass, this));

        getServer().getPluginManager().registerEvents(new BPMenu(this), this);

        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("Battle Pass Plugin has been enabled!");
        for (Player player : getServer().getOnlinePlayers()){
            player.sendMessage(ChatColor.AQUA + "Версия плагина: " + getDescription().getVersion());
        }
    }
    @EventHandler
    void onPlayerJoin(PlayerJoinEvent e){
        e.getPlayer().sendMessage(ChatColor.AQUA + "Версия плагина: " + getDescription().getVersion());
    }
}
