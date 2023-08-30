package xyz.pugly.customenchants.core.effects;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import xyz.pugly.customenchants.utils.Message;

import java.util.Map;

public class PotionEffect extends Effect {
    public PotionEffect() {
        super("potion_effect");
    }

    public void apply(Player p, Map<String, Object> data, int level) {
        if (Math.random() > parseDouble(data.get("chance"), level))
            return;

        try {
            p.addPotionEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.getByName(parseString(data.get("type"))), parseInt(data.get("amplifier"), level), parseInt(data.get("amplifier"), level), false, parseBoolean(data.get("particles"))));
        } catch (Exception e) {
            Message.warn("Invalid potion effect parameters");
        }
    }
}
