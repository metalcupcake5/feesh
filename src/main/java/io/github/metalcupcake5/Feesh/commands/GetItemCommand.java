package io.github.metalcupcake5.Feesh.commands;

import io.github.metalcupcake5.Feesh.Feesh;
import io.github.metalcupcake5.Feesh.items.ItemManager;
import io.github.metalcupcake5.Feesh.items.Shredder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class GetItemCommand implements CommandExecutor {

    private final Feesh plugin;

    public GetItemCommand(Feesh plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if(args.length < 1) {
                return false;
            }
            Player player = (Player) sender;
            PlayerInventory inventory = player.getInventory();
            String id = args[0];
            if(ItemManager.ITEMS.containsKey(id)){
                ItemStack item = ItemManager.ITEMS.get(id).makeNewStack();
                inventory.addItem(item);
                sender.sendMessage("Gave " + id);
            } else {
                sender.sendMessage("Invalid item!");
            }
            return true;
        } else {
            return false;
        }
    }
}
