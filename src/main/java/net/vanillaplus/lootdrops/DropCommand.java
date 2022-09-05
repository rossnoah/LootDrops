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
            x= x+(int)(Math.random()*80)+ 60;
        }else{
            x = x-(int)(Math.random()*80)+ 60;
        }

        int z = centerZ;
        if(random.nextBoolean()){
            z= z +(int)(Math.random()*80)+ 60;
        }else{
            z= z+(int)(Math.random()*80)+ 60;
        }
        int countdown = countdownDuration;


        int xOffset = x + (int)(Math.random()*20);
        int zOffset = z + (int)(Math.random()*20);
        int yOffset = y + (int)(Math.random()*5);




        String str1 = ChatColor.GOLD + "" + "Loot drop in ";

        String str2 = ChatColor.GOLD + "" + " minutes near ("
                + xOffset + "," + yOffset + "," + zOffset + ")";

        String str3 = ChatColor.GOLD + "" + " minutes near ("
                + xOffset + "," + yOffset + "," + zOffset + ")";

        String str4 = ChatColor.GOLD + "" + " seconds near ("
                + xOffset + "," + yOffset + "," + zOffset + ")";
        String str5 = ChatColor.GOLD + ""  + " seconds near ("
                + xOffset + "," + yOffset + "," + zOffset + ")";


        announce(str1 + 5 + str2);

        //Run command as console
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "discordsrv:discordsrv broadcast #1016111922288021524 <@&1016386237306777731> **Loot drop spawning in 5 minutes near ("+xOffset+","+yOffset+","+zOffset+")**");
        // Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "discordsrv:discordsrv broadcast #1016111922288021524 https://cdn.discordapp.com/attachments/756260642293547008/1016120022885732472/unknown.png");


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



            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {


               announce(str1 + "10" + str4);




            },5800);

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            announce(str1 + "5" + str4);
        },5900);

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            announce(str1 + "3" + str4);
        },5940);




    }
}


