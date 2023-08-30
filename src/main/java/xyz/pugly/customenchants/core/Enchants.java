package xyz.pugly.customenchants.core;

import org.bukkit.plugin.Plugin;
import xyz.pugly.customenchants.CustomEnchants;
import xyz.pugly.customenchants.utils.JarUtil;
import xyz.pugly.customenchants.utils.Message;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Enchants {

    private static final Plugin plugin = CustomEnchants.getPlugin(CustomEnchants.class);
    private static final HashMap<String, Enchant> enchants = new HashMap<>();

    public static void reload() {
        Message.info(Message.PREFIX.get() + "Reloading enchants");
        enchants.clear();

        File enchantsFolder = new File(plugin.getDataFolder(), "enchants");

        if (!enchantsFolder.exists()) {

            try {
                JarUtil.copyFolderFromJar("resources/enchants", enchantsFolder, JarUtil.CopyOption.COPY_IF_NOT_EXIST);
            } catch (IOException e) {
                Message.error("Failed to copy enchants folder from jar");
            }

        }

        File[] enchantFiles = enchantsFolder.listFiles();

        if (enchantFiles == null) {
            Message.error("Failed to load enchants");
            return;
        }

        for (File f : enchantFiles) {
            if (!f.getName().endsWith(".yml"))
                continue;

            Enchant enchant = new Enchant(f);
            enchants.put(enchant.getID(), enchant);
            Message.info(Message.PREFIX.get() + "Loaded enchant " + enchant.getID());
        }
    }

}
