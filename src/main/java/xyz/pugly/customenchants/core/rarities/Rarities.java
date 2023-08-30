package xyz.pugly.customenchants.core.rarities;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import xyz.pugly.customenchants.CustomEnchants;
import xyz.pugly.customenchants.utils.Message;

import java.io.File;
import java.util.HashMap;

public class Rarities {

    private static final Plugin plugin = CustomEnchants.getPlugin(CustomEnchants.class);

    private static final HashMap<String, Rarity> rarities = new HashMap<>();

    public static void reload() {
        File raritiesFile = new File(plugin.getDataFolder(), "rarities.yml");

        if (!raritiesFile.exists()) {
            plugin.saveResource("rarities.yml", false);
        }

        YamlConfiguration raritiesConfig = YamlConfiguration.loadConfiguration(raritiesFile);

        if (!raritiesConfig.contains("rarities")) {
            Message.warn(Message.RARITY_CONFIG_INCORRECT);
            return;
        }

        ConfigurationSection rarities = raritiesConfig.getConfigurationSection("rarities");

        for (String s : raritiesConfig.getKeys(false)) {
            if (!raritiesConfig.isConfigurationSection(s))
                continue;

            ConfigurationSection section = raritiesConfig.getConfigurationSection(s);
            if (!(section.contains("name") || section.contains("color")))
                Message.warn(Message.RARITY_CONFIG_INCORRECT);

            String name = section.getString("name");
            String color = section.getString("color");

            Rarity rarity = new Rarity(name, s, color);
            Rarities.rarities.put(s, rarity);
        }

    }

    public static Rarity get(String id) {
        return rarities.get(id);
    }

}
