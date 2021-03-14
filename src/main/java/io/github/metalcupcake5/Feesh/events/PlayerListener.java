package io.github.metalcupcake5.Feesh.events;

import io.github.metalcupcake5.Feesh.Feesh;
import io.github.metalcupcake5.Feesh.items.ItemManager;
import io.github.metalcupcake5.Feesh.utils.Constants;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class PlayerListener implements Listener {

    private final Feesh plugin;

    public PlayerListener(Feesh plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent event){
        Action action = event.getAction();
        if(action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
            if(event.getItem() != null && event.getItem().equals(ItemManager.SCUBA_TANK.makeNewStack())){
                Player player = event.getPlayer();
                Inventory inventory = Constants.scubaTankInventory(player);
                player.openInventory(inventory);
                event.setCancelled(true);
            }
        }
    }

}
