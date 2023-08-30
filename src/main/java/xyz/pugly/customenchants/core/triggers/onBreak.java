package xyz.pugly.customenchants.core.triggers;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class onBreak extends Trigger {

    private Player player;
    private Block block;

    public onBreak(Player player, Block block) {
        super("on_break");
        this.player = player;
        this.block = block;
    }

    public Player getPlayer() {
        return player;
    }

    public Block getBlock() {
        return block;
    }
}
