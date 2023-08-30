package xyz.pugly.customenchants.core.effects;

import xyz.pugly.customenchants.utils.Message;

public abstract class Effect {
    //TODO literally no clue gotta figure out how to apply stuff

    protected String id = "default effect ID";

    public Effect(String id) {
        Effects.register(id, this);
    }

    public void apply() {
        Message.info("Missing args for effect: " + id);
    }

}
