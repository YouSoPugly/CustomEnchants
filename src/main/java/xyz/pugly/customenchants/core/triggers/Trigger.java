package xyz.pugly.customenchants.core.triggers;

public abstract class Trigger {

    /*

    Types:
    on_damage / DONE
    on_kill
    on_hit / DONE
    on_break / DONE
    on_xp_gain
    on_fish
    repeating

     */

    protected String id;

    public Trigger(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
