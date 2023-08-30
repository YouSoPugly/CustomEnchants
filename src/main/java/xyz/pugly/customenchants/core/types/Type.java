package xyz.pugly.customenchants.core.types;

import org.bukkit.Material;

import java.util.Collection;
import java.util.Set;

public class Type {

    private final String name;
    private final String id;
    private final Slot slot;
    private final Set<Material> items;
    private final Set<Type> children;

    public Type(String name, String id, Slot slot, Set<Material> items, Set<Type> children) {
        this.name = name;
        this.id = id;
        this.slot = slot;
        this.items = items;
        this.children = children;
    }

    public Type(String name, String id, Slot slot, Set<Material> items) {
        this(name, id, slot, items, null);
    }

    public Type(String name, String id, Set<Type> children) {
        this(name, id, null, null, children);
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }

    public Slot getSlot() {
        return slot;
    }

    public Set<Material> getItems() {
        return items;
    }

    public Set<Type> getChildren() {
        return children;
    }

    public boolean isItem(Material material) {
        return items.contains(material);
    }

    public boolean isItem(Collection<Material> materials) {
        for (Material material : materials)
            if (isItem(material))
                return true;
        return false;
    }
}
