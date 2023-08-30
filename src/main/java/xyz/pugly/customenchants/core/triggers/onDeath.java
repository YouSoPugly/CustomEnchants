package xyz.pugly.customenchants.core.triggers;

import org.bukkit.entity.Player;

public class onDeath extends Trigger {

    private Player player;

    public onDeath(Player player) {
        super("on_death");
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
