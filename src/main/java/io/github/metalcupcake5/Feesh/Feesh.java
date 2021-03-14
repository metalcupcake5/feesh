package io.github.metalcupcake5.Feesh;

import io.github.metalcupcake5.Feesh.commands.GetItemCommand;
import io.github.metalcupcake5.Feesh.events.EventListener;
import io.github.metalcupcake5.Feesh.events.FishingListener;
import io.github.metalcupcake5.Feesh.events.PlayerListener;
import io.github.metalcupcake5.Feesh.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.HashMap;
import java.util.UUID;

public class Feesh extends JavaPlugin {

    public static HashMap<UUID, Integer> oxygenLeft = new HashMap<UUID, Integer>();
    public static HashMap<UUID, Integer> bottlesStored = new HashMap<>();

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        Boolean logging = this.getConfig().getBoolean("logging");

        new FishingListener(this);
        new PlayerListener(this);
        new EventListener(this);

        getCommand("getItem").setExecutor(new GetItemCommand(this));

        if(logging) {
            getLogger().info("Fishing plugin enabled.");
        }

        BukkitScheduler scheduler = getServer().getScheduler();

        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                oxygenLeft.forEach((uuid, value) -> {
                    Player player = Bukkit.getServer().getPlayer(uuid);
                    if(value == 0) {
                        player.removePotionEffect(PotionEffectType.WATER_BREATHING);
                        oxygenLeft.remove(uuid);
                    } else {
                        ItemStack chestplate = player.getInventory().getChestplate();
                        if (!player.hasPotionEffect(PotionEffectType.WATER_BREATHING)) {
                            if(chestplate != null && chestplate.equals(ItemManager.SCUBA_TANK.makeNewStack())) {
                                player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, value * 20, 1));
                            }
                        } else {
                            if(chestplate == null || !chestplate.equals(ItemManager.SCUBA_TANK.makeNewStack())) {
                                player.removePotionEffect(PotionEffectType.WATER_BREATHING);
                            }
                            oxygenLeft.put(uuid, value - 1);
                        }

                    }
                });
            }
        }, 0L, 20L);
    }

    @Override
    public void onDisable() {
        Boolean logging = this.getConfig().getBoolean("logging");
        if(logging) {
            getLogger().info("Fishing plugin disabled");
        }
    }
}
