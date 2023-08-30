package xyz.pugly.customenchants.core.triggers;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class onXpGain extends Trigger {
    private Player player;
    private PlayerExpChangeEvent event;

    public onXpGain(PlayerExpChangeEvent event, Player player) {
        super("on_xp_gain");
    }

    public Player getPlayer() {
        return player;
    }

    public PlayerExpChangeEvent getEvent() {
        return event;
    }
}
