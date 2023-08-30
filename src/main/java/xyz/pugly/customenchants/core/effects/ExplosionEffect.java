package xyz.pugly.customenchants.core.effects;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import xyz.pugly.customenchants.utils.Message;

import java.util.Map;
import static xyz.pugly.customenchants.core.effects.Effect.*;

public class ExplosionEffect extends Effect {
    public ExplosionEffect(String id) {
        super(id);
    }

    public void apply(Player p, Map<String, Object> data, int level) {
        try {
            Location loc = p.getLocation();
            loc.getWorld().createExplosion(loc, parseInt(data.get("power"), level), false, parseBoolean(data.get("break_blocks")));
        } catch (Exception e) {
            Message.warn("Invalid explosion parameters");
        }
    }
}
