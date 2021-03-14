package io.github.metalcupcake5.Feesh.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {
    public static void sendDebug(Player player, String message){
        player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "[DEBUG]" + ChatColor.GRAY + ":" + message);
    }
}
