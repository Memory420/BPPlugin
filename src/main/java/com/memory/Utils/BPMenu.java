package com.memory.Utils;

import com.memory.BattlePass;
import com.memory.Level;
import com.memory.Main;
import com.memory.Reward;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class BPMenu implements Listener {

    public BPMenu(Main main) {
        BPMenu.main = main;
    }

    private static Main main;
    private static final String MENU_TITLE = ChatColor.GOLD + "Баттл Пасс";

    public static Inventory generateBPMenu(Player player, int listNum, BattlePass bp, JavaPlugin plugin) {
        Inventory inventory = Bukkit.createInventory(player, 27, MENU_TITLE);
        int[] slots = {9, 10, 11, 12, 13, 14, 15, 16, 17};
        int startIndex = (listNum - 1) * 9;
        int endIndex = startIndex + 9;

        Level[] levelsArray = bp.getLevels().values().toArray(new Level[0]);

        for (int i = startIndex, slotIndex = 0; i < endIndex && i < levelsArray.length && slotIndex < slots.length; i++, slotIndex++) {
            Level level = levelsArray[i];
            Reward reward = level.getReward();
            String name = reward.getName();
            int amount = reward.getAmount();

            // Создание предмета
            ItemStack item = ItemFromString(name, amount);

            // Добавление тега с ключом "bp_item" и значением "true"
            PDCUtils.setTag(item, "bp_item", "true");

            inventory.setItem(slots[slotIndex], item);
        }

        return inventory;
    }


    public static ItemStack ItemFromString(String name, int amount) {
        if (name == null || name.isEmpty()) {
            return new ItemStack(Material.BARRIER, 1);
        }
        if (name.equalsIgnoreCase("xp")) {
            return new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
        }

        Material material = Material.matchMaterial(name.toUpperCase());
        if (material == null) {
            return new ItemStack(Material.BARRIER, 1);
        }
        return new ItemStack(material, amount);
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(MENU_TITLE)) {
            event.setCancelled(true);  // Блокируем взаимодействие с инвентарем
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem != null && clickedItem.getType() != Material.AIR) {
                Player player = (Player) event.getWhoClicked();

                // Проверяем наличие тега "bp_item"
                if (PDCUtils.hasTag(clickedItem, "bp_item")) {
                    // Извлекаем значение тега "bp_item"
                    String tagValue = PDCUtils.getTag(clickedItem, "bp_item");
                    player.sendMessage("Тег 'bp_item': " + tagValue);
                } else {
                    player.sendMessage("У предмета нет тега 'bp_item'.");
                }
            }
        }
    }


}

