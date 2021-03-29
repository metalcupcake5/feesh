package io.github.metalcupcake5.Feesh.mobs;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Yeti implements Mob {
    @Override
    public void spawnMob(World world, Location location, Player player) {
        /*MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer nmsWorld = ((CraftWorld) Bukkit.getWorlds().get(0)).getHandle();
        GameProfile profile = new GameProfile(UUID.randomUUID(), ChatColor.RED + "Yeti");
        String[] skin = PlayerSkin.getFromName("Yeti");
        //Base64 base64 = new Base64();
        //byte[] encodedData = base64.encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        //profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        profile.getProperties().put("textures", new Property("textures", skin[0], skin[1]));
        EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, profile, new PlayerInteractManager(nmsWorld));
        npc.setLocation(location.getX(), location.getY(), location.getZ(), 0, 0);
        PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));*/
        Yeti2.createNPC(player, "Yeti", world, location);
        //Yeti2.setSkin(yeti);
        //NPC npc = new NPC("Yeti", location, "Yeti");
        //npc.show(player);
    }

    @Override
    public String spawnMessage() {
        return ChatColor.GREEN + "YETI!!!!";
    }
}
