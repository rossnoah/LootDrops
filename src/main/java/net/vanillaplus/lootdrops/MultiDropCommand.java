package net.vanillaplus.lootdrops;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MultiDropCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //broadcast to all online players
        for(Player p: Bukkit.getOnlinePlayers()){
            p.sendMessage("§6§lMULTIDROP EVENT STARTING NOW, FIRST DROP IN 5 MINUTES!");
        }


            String discordCommand = "discordsrv:discordsrv broadcast #987080007832707132 <@&909709653301157909> **MULTIDROP EVENT STARTING IN 5 MINUTES** \n> :arrow_double_down: This event is on the survival server, join using the normal IP :arrow_double_down: \n> `play.vanillaplus.net`\n> *For those that don't know multidrops are an event where a bunch of loot drops are spawned a minute apart. It’s often very chaotic and a bunch of players fight over the loot.\n> Loot drops are simply chests surrounded by 2 layers of crying obsidian.*\nhttps://i.imgur.com/tR9sSAG.png ";

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), discordCommand);
            //run command as console
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lootdrop");

        //start the event

        SchedulerUtils.runLater(() -> {
            //run command as console
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lootdrop");
        }, 20 * 60);

        SchedulerUtils.runLater(() -> {
            //run command as console
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lootdrop");
        }, 20 * 120);

        SchedulerUtils.runLater(() -> {
            //run command as console
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lootdrop");
        }, 20 * 180);

        SchedulerUtils.runLater(() -> {
            //run command as console
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lootdrop");
        }, 20 * 240);



        return true;
    }
}
