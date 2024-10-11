package com.memory.commands;

import com.memory.BattlePass;
import com.memory.Utils.BPMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class BPOpenMenu implements CommandExecutor {
    private final BattlePass bp;

    public BPOpenMenu(BattlePass bp) {
        this.bp = bp;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Только для игроков");
        } else {
            Inventory inventory = BPMenu.generateBPMenu(((Player) sender).getPlayer(), 1, bp);
            ((Player) sender).getPlayer().openInventory(inventory);
        }
        return true;
    }
}
