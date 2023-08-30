package xyz.pugly.customenchants.utils;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import xyz.pugly.customenchants.CustomEnchants;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;

public enum Message {

    PREFIX,

    LOADED_MESSAGES,
    LOADED_ENCHANTS,

    ENCHANT_NOT_FOUND,
    ENCHANT_CONFIG_INCORRECT,

    RARITY_NOT_FOUND,
    RARITY_CONFIG_INCORRECT,

    TYPE_NOT_FOUND,
    TYPE_CONFIG_INCORRECT,

    COMMAND_NO_PERMISSION,
    COMMAND_INVALID_USAGE,
    COMMAND_RELOAD,
    COMMAND_RELOAD_SUCCESS,
    COMMAND_RELOAD_FAIL,
    COMMAND_ENCHANT,
    COMMAND_ENCHANTS_LIST,
    COMMAND_ENCHANTS_LIST_SWORD,
    COMMAND_ENCHANTS_LIST_BOW,
    COMMAND_ENCHANTS_LIST_ARMOR,
    COMMAND_ENCHANTS_LIST_TOOL;

    private String text;

    Message() {}

    public void set(String text) {
        this.text = text;
    }

    public String get() {
        return text;
    }

    private static final Plugin plugin = CustomEnchants.getPlugin(CustomEnchants.class);
    private static final MiniMessage mm = MiniMessage.miniMessage();
    public static void reload() {
        File langFolder = new File(plugin.getDataFolder(), "lang");

        if (!langFolder.exists()) {
            plugin.saveResource("lang/en.yml", false);
        }

        File langFile = new File(plugin.getDataFolder(), "lang/en.yml");

        YamlConfiguration lang = YamlConfiguration.loadConfiguration(langFile);

        for (Message message : values()) {
            if (lang.isString(message.name())) {
                message.set(lang.getString(message.name()));
            }
        }
    }

    public static void send(Audience audience, String message) {
        audience.sendMessage(mm.deserialize(getMessage(PREFIX) + message));
    }

    public static void send(Player p, String message) {
        p.sendMessage(mm.deserialize(getMessage(PREFIX) + message));
    }

    public static void info(String message) {
        plugin.getLogger().info(message);
    }

    public static void info(Message message) {
        plugin.getLogger().info(message.get());
    }

    public static void warn(String message) {
        plugin.getLogger().warning(message);
    }

    public static void warn(Message message) {
        plugin.getLogger().warning(message.get());
    }

    public static void error(String message) {
        plugin.getLogger().severe(message);
    }

    public static void error(Message message) {
        plugin.getLogger().severe(message.get());
    }

    public static String getMessage(String key) {
        return Message.valueOf(key).get();
    }

    public static String getMessage(Message message) {
        return message.get();
    }

}
