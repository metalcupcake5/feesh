package io.github.metalcupcake5.Feesh.events;

import io.github.metalcupcake5.Feesh.Feesh;
import io.github.metalcupcake5.Feesh.items.ItemManager;
import io.github.metalcupcake5.Feesh.utils.ChatUtils;
import io.github.metalcupcake5.Feesh.utils.FishingUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

public class FishingListener implements Listener {

    private final Feesh plugin;

    public FishingListener(Feesh plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void playerFishEvent(PlayerFishEvent event) {
        PlayerFishEvent.State state = event.getState();
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();
        if(state == PlayerFishEvent.State.FISHING) {
            FishHook hook = event.getHook();
            System.out.println(FishingUtils.getBiteTime(hook));
            BukkitScheduler scheduler = plugin.getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    ChatUtils.sendDebug(player, FishingUtils.getBiteTime(hook) + "left");
                }
            }, 5L);
            if(item.equals(ItemManager.ROD_OF_LEGENDS.makeNewStack()) || item.equals(ItemManager.NO.makeNewStack()) || item.equals(ItemManager.SHREDDER.makeNewStack())) {
                FishingUtils.setBiteTime(hook, 40);
            }
        } else if(state == PlayerFishEvent.State.CAUGHT_FISH) {
            int seaCreatureChance = FishingUtils.calculateSeaCreatureChance(item);
            boolean caughtSeaCreature = FishingUtils.caughtRare(seaCreatureChance);
            boolean caughtTreasure = FishingUtils.caughtRare(20);
            if(caughtSeaCreature){
                Entity caught = event.getCaught();
                Location location = caught.getLocation();
                caught.remove();
                FishingUtils.spawnSeaCreature(player.getWorld(), location, player);
            } else if(caughtTreasure) {
                Item caught = (Item) event.getCaught();
                caught.setItemStack(new ItemStack(Material.DIAMOND));
                player.sendMessage("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "GREAT CATCH!" + ChatColor.RESET + ChatColor.GRAY + "You found a diamond yes very rare");
            }
        }
    }

}
