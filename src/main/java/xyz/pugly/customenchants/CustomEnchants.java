package xyz.pugly.customenchants;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.pugly.customenchants.core.rarities.Rarities;
import xyz.pugly.customenchants.utils.Message;

public final class CustomEnchants extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Message.reload();
        Rarities.reload();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
