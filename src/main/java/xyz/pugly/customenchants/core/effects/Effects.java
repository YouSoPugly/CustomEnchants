package xyz.pugly.customenchants.core.effects;

import java.util.HashMap;
import java.util.Map;

public class Effects {

    //TODO: Add effects
    // potion_effect DONE
    // vein_miner
    // xp_boost
    // auto_smelt
    // durability
    // hunger
    // health
    // explosion DONE

    private static final Map<String, Effect> effects = new HashMap<>();

    public static void register(String id, Effect effect) {
        if (effects.containsKey(id))
            throw new IllegalArgumentException("Effect ID already registered");
        effects.put(id, effect);
    }

    public static Effect get(String id) {
        return effects.get(id);
    }
}
