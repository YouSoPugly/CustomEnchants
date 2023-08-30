package xyz.pugly.customenchants.core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import xyz.pugly.customenchants.core.triggers.onDeath;

public class playerDeathEvent implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        new onDeath(event.getPlayer());
    }
}
