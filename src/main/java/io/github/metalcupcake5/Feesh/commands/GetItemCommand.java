package io.github.metalcupcake5.Feesh.commands;

import io.github.metalcupcake5.Feesh.Feesh;
import io.github.metalcupcake5.Feesh.items.Shredder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class GetItemCommand implements CommandExecutor {

    private final Feesh plugin;

    public GetItemCommand(Feesh plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //command code here
        if (sender instanceof Player) {
            Player player = (Player) sender;
            PlayerInventory inventory = player.getInventory();
            inventory.addItem(Shredder.shredder);
            sender.sendMessage("added a rod to your inventory");
            return true;
        } else {
            return false;
        }
    }
}
