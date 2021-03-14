package io.github.metalcupcake5.Feesh.mobs;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class Squid implements Mob {
    @Override
    public void spawnMob(World world, Location location, Player player) {
        EntityType mob = EntityType.SQUID;

        LivingEntity spawnedMob = (LivingEntity) world.spawnEntity(location, mob);
        spawnedMob.setMaxHealth(0.1);
    }

    @Override
    public String spawnMessage() {
        return ChatColor.GREEN + "You caught a lowly squid.";
    }
}
