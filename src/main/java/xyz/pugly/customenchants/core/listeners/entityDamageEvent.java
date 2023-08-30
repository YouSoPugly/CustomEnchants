package xyz.pugly.customenchants.core.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import xyz.pugly.customenchants.core.triggers.onDamage;
import xyz.pugly.customenchants.core.triggers.onHit;

public class entityDamageEvent implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        Entity attacker = event.getDamager();
        Entity victim = event.getEntity();
        if ((attacker instanceof Player))
            new onDamage((Player) attacker, victim, ((Player)attacker).getInventory().getItemInMainHand(), event.getDamage());

        new onHit((Player) victim, attacker, event.getDamage());
    }
}
