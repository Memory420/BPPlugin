package com.memory.Utils;

import com.memory.BattlePass;
import com.memory.Level;
import com.memory.Reward;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BPMenu implements Listener {

    public static Inventory generateBPMenu(Player player, int listNum, BattlePass bp) {
        Inventory inventory = Bukkit.createInventory(player, 27, ChatColor.GOLD + "Баттл Пасс");

        int[] slots = {9, 10, 11, 12, 13, 14, 15, 16, 17};

        int startIndex = (listNum - 1) * 9;
        int endIndex = startIndex + 9;

        Level[] levelsArray = bp.getLevels().values().toArray(new Level[0]);

        for (int i = startIndex, slotIndex = 0; i < endIndex && i < levelsArray.length && slotIndex < slots.length; i++, slotIndex++) {
            Level level = levelsArray[i];
            Reward reward = level.getReward();
            String name = reward.getName();
            int amount = reward.getAmount();

            inventory.setItem(slots[slotIndex], ItemFromString(name, amount));
        }

        return inventory;
    }

    public static ItemStack ItemFromString(String name, int amount) {
        if (name == null || name.isEmpty()) {
            return new ItemStack(Material.BARRIER, 1);
        }

        if (name.equalsIgnoreCase("xp")) {
            return new ItemStack(Material.EXPERIENCE_BOTTLE, amount);
        }

        Material material = Material.matchMaterial(name.toUpperCase());
        if (material == null) {
            return new ItemStack(Material.BARRIER, 1);
        }

        return new ItemStack(material, amount);
    }
}
