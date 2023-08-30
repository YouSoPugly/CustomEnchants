package xyz.pugly.customenchants.core.types;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import xyz.pugly.customenchants.CustomEnchants;
import xyz.pugly.customenchants.core.rarities.Rarities;
import xyz.pugly.customenchants.core.rarities.Rarity;
import xyz.pugly.customenchants.utils.Message;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

public class Types {

    private static final Plugin plugin = CustomEnchants.getPlugin(CustomEnchants.class);
    private static final HashMap<String, Type> types = new HashMap<>();

    public static void reload() {
        File types = new File(plugin.getDataFolder(), "types.yml");

        if (!types.exists()) {
            plugin.saveResource("types.yml", false);
        }

        YamlConfiguration typesConfig = YamlConfiguration.loadConfiguration(types);

        ConfigurationSection section = typesConfig.getConfigurationSection("types");

        if (section == null) {
            Message.warn(Message.TYPE_CONFIG_INCORRECT);
            return;
        }

        if (section.getKeys(false).isEmpty()) {
            Message.warn(Message.TYPE_CONFIG_INCORRECT);
            return;
        }




    }

}
