package xyz.pugly.customenchants.core.effects;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerExpChangeEvent;
import xyz.pugly.customenchants.utils.Message;

import java.util.Map;

public class XPBoostEffect extends Effect {
    public XPBoostEffect() {
        super("xp_boost");
    }

    public void apply(PlayerExpChangeEvent event, Map<String, Object> data, int level) {
        try {
            if (Math.random() < parseDouble(data.get("chance"), level))
                event.setAmount(event.getAmount() * 2);
        } catch (Exception e) {
            Message.warn("Invalid xp boost parameters");
        }
    }
}
