package xyz.pugly.customenchants.core;

/*
Example Enchant Config:

# Enchant ID is the name of the file

display-name: "Night Vision" # This is the name that will be displayed in the enchants list, as well as in the lore of the item
description: "Gives you night vision" # This is the description that will be displayed in the enchants list
type: armor # This is the type of enchantment. Valid types are found in types.yml
rarity: common # This is the rarity of the enchantment. Valid rarities are found in rarities.yml
max-level: 1 # This is the maximum level of the enchantment
item: GOLDEN_CARROT # This is the item that will be displayed in the list of enchants

# This is the list of effects that will be applied with triggers,
# if you do not want any effects, you can remove this section entirely
effects:
  - id: potion_effect
    duration: 10 # This is the duration of the effect in seconds
    amplifier: 0 # This is the amplifier of the effect
    particles: false # This is whether or not the effect will have particles
    chance: 1 # This is the chance of the potion being applied from 0-1
    effect: night_vision # This is the effect that will be applied. Valid effects are found at https://minecraft.fandom.com/wiki/Effect
    trigger: repeating # This is the trigger type, valid triggers are repeating (with a delay defined), on_hit (with a target), on_damage (with a target), on_break, on_xp_gain


 */


import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.Yaml;
import xyz.pugly.customenchants.core.effects.Effect;
import xyz.pugly.customenchants.core.effects.Effects;
import xyz.pugly.customenchants.core.rarities.Rarities;
import xyz.pugly.customenchants.core.rarities.Rarity;
import xyz.pugly.customenchants.core.triggers.Trigger;
import xyz.pugly.customenchants.core.types.Type;
import xyz.pugly.customenchants.core.types.Types;
import xyz.pugly.customenchants.utils.Message;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Enchant {
    private String id;
    private String displayName;
    private String description;
    private Type type;
    private Rarity rarity;
    private int maxLevel;
    private Material item;
    private Map<Effect, Map<String, Object>> effects;
    private Trigger trigger;

    public Enchant(File f) {
        String id = f.getName().toLowerCase().replace(".yml", "");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);

        this.id = id;
        this.displayName = config.getString("display-name");
        this.description = config.getString("description");
//        this.type = Types.get(config.getString("type"));
        this.rarity = Rarities.get(config.getString("rarity"));
        this.maxLevel = config.getInt("max-level");
        this.item = Material.valueOf(config.getString("item"));

        parseEffects(config.getConfigurationSection("effects"));
    }

    public Enchant(String id, String displayName, String description, Type type, Rarity rarity, int maxLevel, Material item, ConfigurationSection effects) {
        this.id = id;
        this.displayName = displayName;
        this.description = description;
        this.type = type;
        this.rarity = rarity;
        this.maxLevel = maxLevel;
        this.item = item;

        parseEffects(effects);
    }

    private void parseEffects(ConfigurationSection effects) {
        @NotNull List<Map<?, ?>> effectList = effects.getMapList("effects");

        for (Map<?,?> m : effectList) {

            if (m.get("id") == null) {
                Message.error("Missing effect ID for enchant: " + id);
                continue;
            }

            this.effects.put(Effects.get((String) m.get("id")), (Map<String, Object>) m);
        }
    }

    public String getID() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public Material getItem() {
        return item;
    }

    public Map<Effect, Map<String, Object>> getEffects() {
        return effects;
    }
}
