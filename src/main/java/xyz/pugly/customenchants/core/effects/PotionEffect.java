package xyz.pugly.customenchants.core.effects;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class PotionEffect extends Effect {
    public PotionEffect() {
        super("potion_effect");
    }

    public void apply(Player p, PotionEffectType effectType, int duration, int amplifier, boolean particles) {
        p.addPotionEffect(new org.bukkit.potion.PotionEffect(effectType, duration, amplifier, false, particles));
    }
}
