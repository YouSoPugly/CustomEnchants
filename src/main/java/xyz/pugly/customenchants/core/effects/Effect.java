package xyz.pugly.customenchants.core.effects;

public abstract class Effect {

    protected String id = "default effect ID";

    public Effect(String id) {
        Effects.register(id, this);
    }

    public abstract void apply();

}
