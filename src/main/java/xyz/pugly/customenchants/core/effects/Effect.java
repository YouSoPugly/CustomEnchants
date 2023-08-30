package xyz.pugly.customenchants.core.effects;

import xyz.pugly.customenchants.utils.Message;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public abstract class Effect {
    //TODO literally no clue gotta figure out how to apply stuff

    private static final ScriptEngineManager mgr = new ScriptEngineManager();
    private static final ScriptEngine engine = mgr.getEngineByName("JavaScript");

    protected String id = "default effect ID";

    public Effect(String id) {
        Effects.register(id, this);
    }

    public void apply() {
        Message.info("Missing args for effect: " + id);
    }

    public static int parseInt(Object o, int level) {
        String s = (String) o;

        s = s.replace("%level%", String.valueOf(level));

        try {
            return (int) engine.eval(s);
        } catch (Exception e) {
            Message.warn("Invalid number: " + s);
            return 0;
        }
    }

    public static double parseDouble(Object o, int level) {
        String s = (String) o;

        s = s.replace("%level%", String.valueOf(level));

        try {
            return (double) engine.eval(s);
        } catch (Exception e) {
            Message.warn("Invalid number: " + s);
            return 0;
        }
    }

    public static String parseString(Object o, int level) {
        String s = (String) o;

        s = s.replace("%level%", String.valueOf(level));

        return s;
    }

    public static String parseString(Object o) {
        return (String) o;
    }

    public static boolean parseBoolean(Object o) {
        try {
            return (boolean) o;
        } catch (Exception e) {
            Message.warn("Invalid boolean: " + o);
            return false;
        }
    }
}
