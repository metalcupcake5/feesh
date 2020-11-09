package io.github.metalcupcake5.Feesh.events;

import io.github.metalcupcake5.Feesh.Feesh;
import io.github.metalcupcake5.Feesh.items.Shredder;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

public class FishingListener implements Listener {

    private final Feesh plugin;

    public FishingListener(Feesh plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void playerFishEvent(PlayerFishEvent event){
        PlayerFishEvent.State state = event.getState();
        if(state == PlayerFishEvent.State.FISHING) {
            Player player = event.getPlayer();
            ItemStack item = player.getItemInHand();

            if(item.equals(Shredder.shredder)) {
                FishHook hook = event.getHook();
                plugin.setBiteTime(hook, 600);
            }
        }
    }

}
