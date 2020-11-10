package io.github.metalcupcake5.Feesh.items;

import org.bukkit.inventory.ItemStack;

public abstract class ItemType {

    protected final String id;
    public ItemType(String id)
    {
        this.id = id.toUpperCase();
        ItemManager.ITEMS.put(this.id, this);
    }

    public abstract ItemStack makeNewStack();
}
