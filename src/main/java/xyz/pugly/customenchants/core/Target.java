package xyz.pugly.customenchants.core;

public enum Target {

    SELF("self"),
    ATTACKER("attacker"),
    VICTIM("victim");

    private String id;

    private Target(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }

}
