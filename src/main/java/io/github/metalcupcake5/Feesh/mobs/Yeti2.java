package io.github.metalcupcake5.Feesh.mobs;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import io.github.metalcupcake5.Feesh.utils.Utils;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Yeti2 extends EntityPlayer {

    public Yeti2(MinecraftServer minecraftserver, WorldServer worldserver, GameProfile gameprofile,
                 PlayerInteractManager playerinteractmanager) {
        super(minecraftserver, worldserver, gameprofile, playerinteractmanager);
    }

    public static Yeti2 createNPC(Player p, String name, World world, Location location) {
        MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer nmsWorld = ((CraftWorld) world).getHandle();
        GameProfile profile = new GameProfile(UUID.randomUUID(), name);
        PlayerInteractManager interactManager = new PlayerInteractManager(nmsWorld);
        Yeti2 entityPlayer = new Yeti2(nmsServer, nmsWorld, profile, interactManager);
        entityPlayer.playerConnection = new PlayerConnection(nmsServer, new NetworkManager(EnumProtocolDirection.CLIENTBOUND), entityPlayer);

        Utils.setSkin(entityPlayer.getBukkitEntity());

        entityPlayer.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());

        nmsWorld.addEntity(entityPlayer);

        PacketPlayOutPlayerInfo playerInfoAdd = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, entityPlayer);
        PacketPlayOutNamedEntitySpawn namedEntitySpawn = new PacketPlayOutNamedEntitySpawn(entityPlayer);
        PacketPlayOutEntityHeadRotation headRotation = new PacketPlayOutEntityHeadRotation(entityPlayer, (byte) ((location.getYaw() * 256f) / 360f));
        PacketPlayOutPlayerInfo playerInfoRemove = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, entityPlayer);

        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
            connection.sendPacket(playerInfoAdd);
            connection.sendPacket(namedEntitySpawn);
            connection.sendPacket(headRotation);
            connection.sendPacket(playerInfoRemove);
        }
        return entityPlayer;
    }

    public static void setSkin(Player p) {
        EntityPlayer player = ((CraftPlayer) p).getHandle();
        GameProfile playerProfile = player.getProfile();

        playerProfile.getProperties().clear();
        String texture = "ewogICJ0aW1lc3RhbXAiIDogMTYxNjk3Mzg4MDgxOCwKICAicHJvZmlsZUlkIiA6ICIzZmM3ZmRmOTM5NjM0YzQxOTExOTliYTNmN2NjM2ZlZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJZZWxlaGEiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGRkMmQzYzZkMDFjMjc2MjI2YzdiMGQzNzcxMjJlMWE2NDdiMmZmYjViOWI1NGZhOThlYWMzN2JiMWQwOWQzYSIKICAgIH0KICB9Cn0=";
        String signature = "eTLX24iCeaMrDUhq9jSz7SEWGcOIXV7ar8bq2BrXtgQPNqC6dqS6+8meqSByA18C19dFwSlMOAmGEtdkE3LysgNgpgX7XWUtDoUeNXjL1rvULD9jzS1dY2h5V/r19v9Mj+KR975vbi2PTYt0oETHT9cisdnLAt9dzrG0m6slS9eM5r1HCw2An3MOO7K+wamLH43glYyqawU/4uB0hmn/irCn2otO7VQZ0JUvBHDyFohuXhKhu0CuhAtks4Or7wjBrTRCVQy+lclhX5/yP9P91hubh1DesZ++vxscw83jxWoQYgni+DTTEDxE2A2POCM/HmbtsRrhWiZ/MuCXlskBQAnnRA9h0We1jGHHcOib56rgcXSs+htBPguVs0U9s88keTGE10MgnXd4PXsETopKYbAj8iLnObysijJIEqYoakijKwINWN3kWFbwytihP5T/oVFK2iQSsv8QskE3c5DSitauCd8NGVvvTq+wQqKdTKRheyodFyTMaJhXuQ6sL4In40659PIc5pfzWvkM0CqNmtFBhov/gOtg16jKOuGmBaXd+VEBBjt3c9dCbyAvqguYFUTXiraUlbMlwSZK3i/7kTv5zyYou4YPiMVIgFQeC1mzdAWk8oseaXWscWOctUOR64FJ/TNbIp1Ej2PT7n5+vAXKVX4NmYCdGxqZO4gqRD8=";
        playerProfile.getProperties().put("textures", new Property("textures", texture, signature));

        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.hidePlayer(p);
            pl.showPlayer(p);
        }
    }

}

