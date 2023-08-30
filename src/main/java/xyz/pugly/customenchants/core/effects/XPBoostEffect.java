package xyz.pugly.customenchants.core.effects;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class XPBoostEffect extends Effect {
    public XPBoostEffect() {
        super("xp_boost");
    }

    public void apply(PlayerExpChangeEvent event) {
        event.setAmount(event.getAmount() * 2);
    }
}
