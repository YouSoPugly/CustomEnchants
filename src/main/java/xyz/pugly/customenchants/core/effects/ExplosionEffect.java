package xyz.pugly.customenchants.core.effects;

import org.bukkit.Location;

public class ExplosionEffect extends Effect {
    public ExplosionEffect(String id) {
        super(id);
    }

    public void apply(Location l, int power, boolean breakBlocks) {
        l.getWorld().createExplosion(l, power, breakBlocks);
    }
}
