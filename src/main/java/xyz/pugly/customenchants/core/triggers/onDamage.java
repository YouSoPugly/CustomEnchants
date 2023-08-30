package xyz.pugly.customenchants.core.triggers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class onDamage extends Trigger {

    private Player attacker;
    private Entity victim;
    private ItemStack weapon;
    private double damage;

    public onDamage(Player attacker, Entity victim, ItemStack weapon, double damage) {
        super("on_damage");
        this.attacker = attacker;
        this.victim = victim;
        this.weapon = weapon;
        this.damage = damage;
    }

    public Player getAttacker() {
        return attacker;
    }

    public Entity getVictim() {
        return victim;
    }

    public ItemStack getWeapon() {
        return weapon;
    }

    public double getDamage() {
        return damage;
    }
}
