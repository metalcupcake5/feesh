package io.github.metalcupcake5.Feesh.items;

import java.util.HashMap;
import java.util.Map;

public class ItemManager {
    public static final Map<String, ItemType> ITEMS = new HashMap<>();

    public static final ItemType SHREDDER = new Shredder();
    public static final ItemType NO = new No();
    public static final ItemType ROD_OF_LEGENDS = new RodOfLegends();
    public static final ItemType ROD_OF_THE_SEA = new RodOfTheSea();
    public static final ItemType SCUBA_TANK = new ScubaTank();
    public static final ItemType BOTTLE_OF_AIR = new BottleOfAir();
    public static final ItemType XP_SHARE = new xpshare();
}
