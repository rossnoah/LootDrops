package net.vanillaplus.lootdrops;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Random;

import static net.vanillaplus.lootdrops.Main.*;


public class DropCommand implements CommandExecutor {
    private final Main plugin = Main.getPlugin(Main.class);


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        summonLootDrop();
        sender.sendMessage("Loot drop executing....");
        return true;
    }


    public void summonLootDrop() {
        Random random = new Random();



        int x = centerX;
        if(random.nextBoolean()){
            x= x+(int)(Math.random()*160)+ 120;
        }else{
            x = x-(int)(Math.random()*160)+ 120;
        }

        int z = centerZ;
        if(random.nextBoolean()){
            z= z +(int)(Math.random()*160)+ 120;
        }else{
            z= z+(int)(Math.random()*160)+ 120;
        }
        int countdown = countdownDuration;
        String str1 = ChatColor.GOLD + "" + ChatColor.BOLD + "Loot drop in ";

        String str2 = ChatColor.GOLD + "" + ChatColor.BOLD + " minutes at ("
                + x + "," + y + "," + z + ")";

        String str3 = ChatColor.GOLD + "" + ChatColor.BOLD + " minutes at ("
                + x + "," + y + "," + z + ")";

        String str4 = ChatColor.GOLD + "" + ChatColor.BOLD + " seconds at ("
                + x + "," + y + "," + z + ")";
        String str5 = ChatColor.GOLD + "" + ChatColor.BOLD + " seconds at ("
                + x + "," + y + "," + z + ")";


        announce(str1 + 5 + str2);


        for (int i = 1; i < 6; i++) {
            int finalI = 5 - i;

            int finalX = x;
            int finalZ = z;
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                if (finalI == 0) {
                    spawnLoot(finalX, y, finalZ);
                    announce(ChatColor.GOLD + "" + ChatColor.BOLD + "LOOT DROP NOW at ("
                            + finalX + "," + y + "," + finalZ + ")");
                } else if (finalI == 1) {
                    announce(str1 + finalI + str3);

                } else {

                    announce(str1 + finalI + str2);
                }


            }, 1200 * i);


        }
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            announce(str1 + 30 + str4);


        }, 5400);

        for (int i = 1; i < 10; i++) {
            int finalI = 10 - i;

            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {

                if (finalI == 1) {
                    announce(str1 + finalI + str5);

                } else {

                    announce(str1 + finalI + str4);
                }


            }, 20 * i + 5800);


            //  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            //          spawnLoot(x,y,z);
            // }, 500);


        }


    }
}


