package xyz.pugly.customenchants.core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import xyz.pugly.customenchants.core.triggers.onBreak;

public class blockBreakEvent implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta() == null)
            return;

        new onBreak(event.getPlayer(), event.getBlock());
    }

}
