package io.github.metalcupcake5.Feesh.mobs;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public interface Mob {
    public void spawnMob(World world, Location location, Player player);

    public String spawnMessage();
}
