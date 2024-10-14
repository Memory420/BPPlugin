package com.memory.commands;

import com.memory.BattlePass;
import com.memory.Main;
import com.memory.Utils.BPMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class BPOpenMenu implements CommandExecutor {
    private final BattlePass bp;
    private final Main m;

    public BPOpenMenu(BattlePass bp, JavaPlugin plugin) {
        this.bp = bp;
        this.m = (Main) plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Только для игроков");
        } else {
            Inventory inventory = BPMenu.generateBPMenu(((Player) sender).getPlayer(), 1, bp, m);
            ((Player) sender).getPlayer().openInventory(inventory);
        }
        return true;
    }
}
