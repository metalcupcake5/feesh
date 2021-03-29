package io.github.metalcupcake5.Feesh.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Utils {
    public static void setSkin(Player p) {
        EntityPlayer player = ((CraftPlayer) p).getHandle();
        GameProfile playerProfile = player.getProfile();

        playerProfile.getProperties().clear();
        String texture = "ewogICJ0aW1lc3RhbXAiIDogMTYxNjk3NTA3MjMyOCwKICAicHJvZmlsZUlkIiA6ICI2MjcxYmRhMzA4ODM0ZDczOGZhZjE5NDY3NzA5MGJjMyIsCiAgInByb2ZpbGVOYW1lIiA6ICJfWXVuZ0dyYXZ5IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2RhZDUyYWMyNGMzYzc1MTAzOWI2MGQyNWRmOWE5YTkyNGQ3YzcxMGFhZTAyYWY3NTQwNjAwYTdhNjM3OTRjZDIiCiAgICB9CiAgfQp9";
        String signature = "MDQ0ZIces1Mfop4oC0avwMxzV6D6K7HjvaEa19XiBIQq7Y2rzbYohjWyjA6nt3TJdSNj2JqpN3GtWkhvpR1+J8VSRSLW3wQ+LDHY2/WkQLlP6/LZovROT4dG9xVqONcIPKuk+nCIAHnJk2ZowH2hwW+opocwOG1/sIH+aO9DTJboREzyFkIxRyjZaOy/zzNWMhAdwBRBoH3hmPUOA9w9wZtbWT6BvTMG8LkdnYNHPGfx8mcuzOBe3YVBaPDu7FpptLnuPHCU3W2q1OAhHKWvW4zLyk6jew7E9qk3P/SZfDQf//XirR9rFjuFVwYdJYPfM5OR6M7qIKbDgOGifkK4Yw/CP9lJyknBt74UBOWhIMEzW7Bzj1gE3WTgY+vajmjdDgKsb4TBCX4q8QawjHrl4+eJx9lbLUFUHHaEZol0/r4WWJxaHEDSa2hlwEqHEE9yCb3qjeeUdf945StZfYh1xYLuEsC8NkD/lAn9D0mMmpjTxzlLbZ+ZxbWiGY1msMYWKZOI1zkrMYxJXBj8cmBJDDHHKHjnpAUeRWf3DPz5GSfxJkOEDEFivrU8hf80WK7H99ycSnNqE6y1ffFhvE5jwtloIRq73n8+IupJ0O7LcnRNtoP58qzObRyilj+H+EzMxVJKTQmH4fMDkqvOQR4RVtj/7Iq7wwHnRp7YGAx2hT8=";

        /*String texture = "ewogICJ0aW1lc3RhbXAiIDogMTYxNjk3ODgyNzY0NiwKICAicHJvZmlsZUlkIiA6ICIzZmM3ZmRmOTM5NjM0YzQxOTExOTliYTNmN2NjM2ZlZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJZZWxlaGEiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDI5YzQ1MmQ4ZWRkZmVmNDk2OWY2YTc5MjBjODEyMzU3OWFlYmM0Njc0NzE0ZGJkNDZiMmZmNDlmMDc0OTQ2NiIKICAgIH0KICB9Cn0=";
        String signature = "Y7eB/2Bssl9hUZMqQ5l0a6zZaPnPDLxn49njZUUb2wvb/qK5gWH+wY5TKVkEBhuA27Mlbwibu3Xi5KpJK4OW1BVQCX8cw0UTFOa6IZ6WIpKqB73BxkvsKrGHnd06kHdLm7mcE2LJMjS3le1WwJPoC1l6cHN+yywqHQcRLAmK1Ei9Mc29Stt/kEOx5/0Fq1qWmYwpmpH4pwyQLXN/7ydV2FX0w6IklNFSwh3Tc+6k6vlUwAGc4pvreGhl5yT9Ia4/VCZmK88kmoaONAFvbN68DFaebWGDnASHJSVvBQd5gFIDj4lrVOwuYyqPILAy6qM4+ls9ze+KaA7p+p4+F+8nziudchrSpmkuCKQJduzpQmx6/Vy+HsW+gT58zQGk8cLPGSX00Q9nynhPNC17r1Ste77Q66a4th1K4s9wtN9Q0PQqqa4ohTRGKiPWIs0Bj5Cx9UPEevyP1lVbqCsD2H5mL4hnrUbb7rdUJ5M8h68ts7bkAQ4/T+mz6dX1bIdkEbELEiPN9taOcMnTQT+JeqQf9E1g86b6mh3XEBebot6xQ7xa5KhM2bhX5ZFtk99ZOIPvbHN67bL6ETN6qowicfL7Qoc956j4fQ+Dz37nndY0AAzi5i6CMguBWuzNIBFZV3r21F5C2TFo68wVCDwsmUcmS2aLHNKCjinPyPrdJC+F2yo=";
        */
        //String[] skin = PlayerSkin.getFromName("Yeti");
        playerProfile.getProperties().put("textures", new Property("textures", texture, signature));

        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.hidePlayer(p);
            pl.showPlayer(p);
        }
    }
}
    // Skin #1150389964 generated on Mar 28, 2021 4:24:41 PM via MineSkin.org - https://minesk.in/1150389964
    /*GameProfile skin1150389964 = new GameProfile(UUID.fromString("79277ed5-1d27-447e-9c1d-077767452eaf"), "skin1150389964");
skin1150389964.getProperties().put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTYxNjk3Mzg4MDgxOCwKICAicHJvZmlsZUlkIiA6ICIzZmM3ZmRmOTM5NjM0YzQxOTExOTliYTNmN2NjM2ZlZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJZZWxlaGEiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGRkMmQzYzZkMDFjMjc2MjI2YzdiMGQzNzcxMjJlMWE2NDdiMmZmYjViOWI1NGZhOThlYWMzN2JiMWQwOWQzYSIKICAgIH0KICB9Cn0=", "eTLX24iCeaMrDUhq9jSz7SEWGcOIXV7ar8bq2BrXtgQPNqC6dqS6+8meqSByA18C19dFwSlMOAmGEtdkE3LysgNgpgX7XWUtDoUeNXjL1rvULD9jzS1dY2h5V/r19v9Mj+KR975vbi2PTYt0oETHT9cisdnLAt9dzrG0m6slS9eM5r1HCw2An3MOO7K+wamLH43glYyqawU/4uB0hmn/irCn2otO7VQZ0JUvBHDyFohuXhKhu0CuhAtks4Or7wjBrTRCVQy+lclhX5/yP9P91hubh1DesZ++vxscw83jxWoQYgni+DTTEDxE2A2POCM/HmbtsRrhWiZ/MuCXlskBQAnnRA9h0We1jGHHcOib56rgcXSs+htBPguVs0U9s88keTGE10MgnXd4PXsETopKYbAj8iLnObysijJIEqYoakijKwINWN3kWFbwytihP5T/oVFK2iQSsv8QskE3c5DSitauCd8NGVvvTq+wQqKdTKRheyodFyTMaJhXuQ6sL4In40659PIc5pfzWvkM0CqNmtFBhov/gOtg16jKOuGmBaXd+VEBBjt3c9dCbyAvqguYFUTXiraUlbMlwSZK3i/7kTv5zyYou4YPiMVIgFQeC1mzdAWk8oseaXWscWOctUOR64FJ/TNbIp1Ej2PT7n5+vAXKVX4NmYCdGxqZO4gqRD8="));
        */
