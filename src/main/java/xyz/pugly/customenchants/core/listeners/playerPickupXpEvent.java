package xyz.pugly.customenchants.core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import xyz.pugly.customenchants.core.triggers.onXpGain;

public class playerPickupXpEvent implements Listener {

    @EventHandler
    public void onPlayerPickupXpEvent(org.bukkit.event.player.PlayerExpChangeEvent event) {
        if (event.getAmount() <= 0)
            return;

        new onXpGain(event, event.getPlayer());
    }

}
