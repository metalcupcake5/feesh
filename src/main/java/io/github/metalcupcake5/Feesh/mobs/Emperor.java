package io.github.metalcupcake5.Feesh.mobs;

import io.github.metalcupcake5.Feesh.utils.Skull;
import org.bukkit.*;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Emperor implements Mob {
    @Override
    public void spawnMob(World world, Location location, Player player) {
        Entity guardian = world.spawnEntity(location, EntityType.GUARDIAN);
        Creature guardianCreature = (Creature) guardian;
        Entity skeleton = world.spawnEntity(location, EntityType.SKELETON);
        Creature skeletonCreature = (Creature) skeleton;

        guardian.setPassenger(skeleton);
        //guardian.setVelocity(velocity);
        guardianCreature.setTarget(player);
        skeletonCreature.setTarget(player);
        ItemStack skull = Skull.getCustomSkull("http://textures.minecraft.net/texture/044b653bbb727b5c865a8efc75092afe939e2c3e68613db9abae4f1b64f99f8");
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemStack[] array = new ItemStack[]{chestplate, leggings, boots};
        for (int i = 0; i < array.length; i++) {
            LeatherArmorMeta meta = (LeatherArmorMeta) array[i].getItemMeta();
            meta.setColor(Color.fromRGB(153, 13, 0));
            array[i].setItemMeta(meta);
        }
        skeletonCreature.getEquipment().setArmorContents(array);
        skeletonCreature.getEquipment().setHelmet(skull);
        skeletonCreature.setMaxHealth(0.1);
        guardianCreature.setMaxHealth(0.1);
    }

    @Override
    public String spawnMessage() {
        return ChatColor.GREEN + "The Sea Emperor rises from the depths...";
    }
}
