package net.vanillaplus.lootdrops;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Locale;
import java.util.Random;


public final class Main extends JavaPlugin {



    static boolean active;

    static int centerX = -224;
    static int centerZ = -240;
    static int y = 73;
    static int countdownDuration = 5; //in minutes




    @Override
    public void onEnable() {
        // Plugin startup logic


        this.getCommand("lootdrop").setExecutor(new DropCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



    public static void announce(String str){

        for (Player p: Bukkit.getOnlinePlayers()
             ) {
            p.sendMessage(str);
        }

    }

    public static void spawnLoot(int x, int y, int z){
        World w = Bukkit.getWorld("world");
        Location dropLoc = new Location(w,x,y,z,0,0);
        Block dropBlock = dropLoc.getBlock();
        dropBlock.setType(Material.CHEST);
        Chest c = (Chest) dropBlock.getState();
        ItemStack[] loot = {
                new ItemStack(Material.TOTEM_OF_UNDYING),
                new ItemStack(Material.TOTEM_OF_UNDYING),
                new ItemStack(Material.EXPERIENCE_BOTTLE,64),
                new ItemStack(Material.GLOWSTONE,16),
                new ItemStack(Material.END_CRYSTAL,64),
                new ItemStack(Material.GLOWSTONE,16),
                new ItemStack(Material.EXPERIENCE_BOTTLE,64),
                new ItemStack(Material.TOTEM_OF_UNDYING),
                new ItemStack(Material.TOTEM_OF_UNDYING),


                new ItemStack(Material.TOTEM_OF_UNDYING),
                new ItemStack(Material.TOTEM_OF_UNDYING),
                new ItemStack(Material.GOLDEN_APPLE,16),
                new ItemStack(Material.NETHERITE_INGOT,2),
                new ItemStack(Material.RESPAWN_ANCHOR,64),
                new ItemStack(Material.NETHERITE_INGOT,2),
                new ItemStack(Material.GOLDEN_APPLE,16),
                new ItemStack(Material.TOTEM_OF_UNDYING),
                new ItemStack(Material.TOTEM_OF_UNDYING),


                new ItemStack(Material.TOTEM_OF_UNDYING),
                new ItemStack(Material.TOTEM_OF_UNDYING),
                new ItemStack(Material.EXPERIENCE_BOTTLE,64),
                new ItemStack(Material.GLOWSTONE,16),
                new ItemStack(Material.END_CRYSTAL,64),
                new ItemStack(Material.GLOWSTONE,16),
                new ItemStack(Material.EXPERIENCE_BOTTLE,64),
                new ItemStack(Material.TOTEM_OF_UNDYING),
                new ItemStack(Material.TOTEM_OF_UNDYING),














        };
        c.getBlockInventory().setContents(loot);

        dropBlock.getRelative(1,0,0).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(-1,0,0).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(0,1,0).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(0,-1,0).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(0,0,1).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(0,0,-1).setType(Material.CRYING_OBSIDIAN);

        dropBlock.getRelative(-2,0,0).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(2,0,0).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(0,-2,0).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(0,2,0).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(0,0,-2).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(0,0,2).setType(Material.CRYING_OBSIDIAN);


        dropBlock.getRelative(1,0,1).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(-1,0,-1).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(1,0,-1).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(-1,0,1).setType(Material.CRYING_OBSIDIAN);

        dropBlock.getRelative(1,1,0).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(-1,1,0).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(0,1,1).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(0,1,-1).setType(Material.CRYING_OBSIDIAN);

        dropBlock.getRelative(1,-1,0).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(-1,-1,0).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(0,-1,-1).setType(Material.CRYING_OBSIDIAN);
        dropBlock.getRelative(0,-1,1).setType(Material.CRYING_OBSIDIAN);



    }


    }




