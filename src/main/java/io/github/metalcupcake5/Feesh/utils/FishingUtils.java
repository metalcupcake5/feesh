package io.github.metalcupcake5.Feesh.utils;

import io.github.metalcupcake5.Feesh.items.ItemManager;
import io.github.metalcupcake5.Feesh.items.ItemType;
import io.github.metalcupcake5.Feesh.mobs.MobManager;
import net.minecraft.server.v1_8_R3.EntityFishingHook;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;
import java.util.Random;

public class FishingUtils {

    private static Random random = new Random();

    public static boolean caughtRare(double chance) {
        int r = random.nextInt(10000) + 1;

        if(chance*100 >= r){
            return true;
        }
        return false;
    }

    public static double calculateTreasureChance(ItemStack heldItem, ItemStack[] armor) {
        double treasureChance = 0;
        for(ItemType item : ItemManager.ITEMS.values()){
            if(item.makeNewStack().isSimilar(heldItem)){
                if(item.getStats().containsKey("treasureChance")){
                    treasureChance += item.getStats().get("treasureChance");
                }
            }
            for(ItemStack armorItem : armor){
                if(item.makeNewStack().equals(armorItem)){
                    treasureChance += item.getStats().get("treasureChance");
                }
            }
        }
        //System.out.println(ItemManager.CORAL_CHESTPLATE.m);
        /*for(ItemStack armorItem : armor){
            for(ItemType item : ItemManager.ITEMS.values()) {
                if(item.makeNewStack().isSimilar(armorItem)){
                    treasureChance += item.getStats().get("treasureChance");
                }
            }


            System.out.println(armorItem.equals(ItemManager.CORAL_CHESTPLATE.makeNewStack()));
        }*/
        return treasureChance;
    }

    public static double calculateSeaCreatureChance(ItemStack heldItem) {
        double seaCreatureChance = 20;
        for(ItemType item : ItemManager.ITEMS.values()){
            if(item.makeNewStack().isSimilar(heldItem)){
                if(item.getStats().containsKey("seaCreatureChance")){
                    seaCreatureChance += item.getStats().get("seaCreatureChance");
                }
            }
        }
        return seaCreatureChance;
    }

    public static void spawnSeaCreature(World world, Location location, Player player){
        //Vector velocity = VelocityUtil.calculateVelocity(location.toVector(), player.getLocation().toVector(), 1);
        Boolean caughtSquid = caughtRare(0);
        if(caughtSquid) {
            MobManager.SQUID.spawnMob(world, location, player);
            player.sendMessage(MobManager.SQUID.spawnMessage());
        } else {
            /*Creature entity = (Creature) world.spawnEntity(location, EntityType.ZOMBIE);
            entity.setVelocity(velocity);
            entity.setTarget(player);
            player.sendMessage(ChatColor.GREEN + "You caught zombie wowo");*/
            //emperor skull
            MobManager.YETI.spawnMob(world, location, player);
            player.sendMessage(MobManager.YETI.spawnMessage());
        }
    }

    public static int getBottles(Integer time) {
        return (int) (Math.floor(time/180));
    }

    public static void setBiteTime(FishHook hook, int time) {
        net.minecraft.server.v1_8_R3.EntityFishingHook hookCopy = (EntityFishingHook) ((CraftEntity) hook).getHandle();

        Field fishCatchTime = null;

        try {
            fishCatchTime = net.minecraft.server.v1_8_R3.EntityFishingHook.class.getDeclaredField("aw");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        fishCatchTime.setAccessible(true);

        try {
            fishCatchTime.setInt(hookCopy, time);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        fishCatchTime.setAccessible(false);
    }

    public static Integer getBiteTime(FishHook hook) {
        net.minecraft.server.v1_8_R3.EntityFishingHook hookCopy = (EntityFishingHook) ((CraftEntity) hook).getHandle();

        Field fishCatchTime = null;

        try {
            fishCatchTime = net.minecraft.server.v1_8_R3.EntityFishingHook.class.getDeclaredField("aw");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        fishCatchTime.setAccessible(true);

        try {
            return fishCatchTime.getInt(hookCopy);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        fishCatchTime.setAccessible(false);
        return null;
    }
}
