package io.github.metalcupcake5.Feesh;

import io.github.metalcupcake5.Feesh.commands.GetItemCommand;
import io.github.metalcupcake5.Feesh.events.FishingListener;
import io.github.metalcupcake5.Feesh.items.ItemManager;
import net.minecraft.server.v1_8_R3.EntityFishingHook;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.FishHook;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public class Feesh extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        Boolean logging = this.getConfig().getBoolean("logging");

        ItemManager.init();

        new FishingListener(this);

        getCommand("getItem").setExecutor(new GetItemCommand(this));

        if(logging) {
            getLogger().info("Fishing plugin enabled.");
        }
    }

    @Override
    public void onDisable() {
        Boolean logging = this.getConfig().getBoolean("logging");
        if(logging) {
            getLogger().info("Fishing plugin disabled");
        }
    }

    public void setBiteTime(FishHook hook, int time) {
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
}
