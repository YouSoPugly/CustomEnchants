package xyz.pugly.customenchants.core.triggers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class onHit extends Trigger {

    private Player victim;
    private Entity attacker;
    private double damage;

    public onHit(Player victim, Entity attacker, double damage) {
        super("on_hit");
        this.victim = victim;
        this.attacker = attacker;
        this.damage = damage;
    }
}
