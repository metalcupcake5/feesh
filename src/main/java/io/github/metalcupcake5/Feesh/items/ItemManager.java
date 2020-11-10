package io.github.metalcupcake5.Feesh.items;

import java.util.HashMap;
import java.util.Map;

public class ItemManager {
    public static final Map<String, ItemType> ITEMS = new HashMap<>();

    public static final ItemType SHREDDER = new Shredder();
    public static final ItemType NO = new No();
}
