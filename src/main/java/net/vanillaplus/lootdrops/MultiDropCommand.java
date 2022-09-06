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
