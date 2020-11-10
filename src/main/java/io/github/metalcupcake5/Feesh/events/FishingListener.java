package io.github.metalcupcake5.Feesh.events;

import io.github.metalcupcake5.Feesh.Feesh;
import io.github.metalcupcake5.Feesh.items.ItemManager;
import io.github.metalcupcake5.Feesh.items.Shredder;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FishingListener implements Listener {

    private final Feesh plugin;

    public FishingListener(Feesh plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void playerFishEvent(PlayerFishEvent event) throws InterruptedException {
        PlayerFishEvent.State state = event.getState();
        Player player = event.getPlayer();
        if(state == PlayerFishEvent.State.FISHING) {
            ItemStack item = player.getItemInHand();

            if(item.equals(ItemManager.SHREDDER.makeNewStack())) {
                FishHook hook = event.getHook();
                plugin.setBiteTime(hook, 40);
            }
        }
        else if(state == PlayerFishEvent.State.CAUGHT_FISH) {
            Random random = new Random();
            int r = random.nextInt(5);
            System.out.println(r);
            if(r == 1){
                Entity item = event.getCaught();
                Location location = item.getLocation();
                Vector velocity = item.getVelocity();
                item.remove();
                Entity entity = player.getWorld().spawnEntity(location, EntityType.SQUID);
                player.sendMessage(ChatColor.GREEN + "You caught a lowly squid.");
                entity.setVelocity(velocity);
            } else if(r == 2) {
                Item item = (Item) event.getCaught();
                item.setItemStack(new ItemStack(Material.DIAMOND));
                player.sendMessage("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "GREAT CATCH!" + ChatColor.RESET + ChatColor.GRAY + "You found a diamond yes very rare");
            }
        }
    }

}
