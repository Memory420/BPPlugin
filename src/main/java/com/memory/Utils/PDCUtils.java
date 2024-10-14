package com.memory.Utils;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class PDCUtils {
    private static JavaPlugin plugin;
    public static final String NAMESPACE = "battlepass";


    public static void init(JavaPlugin mainPlugin) {
        plugin = mainPlugin;
    }
    public static void setTag(ItemStack item, String key, String value) {
        if (item != null && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                PersistentDataContainer container = meta.getPersistentDataContainer();
                NamespacedKey namespacedKey = new NamespacedKey(plugin, key);  // Создаем NamespacedKey
                container.set(namespacedKey, PersistentDataType.STRING, value);  // Устанавливаем тег
                item.setItemMeta(meta);  // Сохраняем изменения в метаданные предмета
            }
        }
    }


    public static boolean hasTag(ItemStack item, String key) {
        if (item != null && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                PersistentDataContainer container = meta.getPersistentDataContainer();
                NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
                return container.has(namespacedKey, PersistentDataType.STRING);
            }
        }
        return false;
    }


    public static String getTag(ItemStack item, String key) {
        if (item != null && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                PersistentDataContainer container = meta.getPersistentDataContainer();
                NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
                return container.get(namespacedKey, PersistentDataType.STRING);
            }
        }
        return null;
    }

}
