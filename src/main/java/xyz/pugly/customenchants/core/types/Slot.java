package xyz.pugly.customenchants.core.types;

public enum Slot {
    HAND("hand"),
    ARMOR("armor"),
    INVENTORY("inventory");

    private String id;
    private Slot(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }
}
