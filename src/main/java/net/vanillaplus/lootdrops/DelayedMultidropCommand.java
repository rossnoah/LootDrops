package net.vanillaplus.lootdrops;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DelayedMultidropCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

       int delay = 1;
       //in hours


        //return if no args
        if(args.length == 0){
            sender.sendMessage("§c§lERROR: §cPlease specify a delay in hours");
            return true;
        }
        //return if not a number
        try{
            delay = Integer.parseInt(args[0]);
        }catch (NumberFormatException e){
            sender.sendMessage("§c§lERROR: §cPlease specify a valid number");
            return true;
        }
        //return if negative
        if(delay < 0){
            sender.sendMessage("§c§lERROR: §cPlease specify a positive number");
            return true;
        }
        //return if too big
        if(delay > 12){
            sender.sendMessage("§c§lERROR: §cPlease specify a number less than 24");
            return true;
        }
        //return if too small
        if(delay < 1){
            sender.sendMessage("§c§lERROR: §cPlease specify a number greater than 0");
            return true;
        }


        //run the command after the delay


String time = ""+((System.currentTimeMillis()/1000)+delay*60*60);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "discordsrv:discordsrv bcast #987080007832707132 **MULTIDROP EVENT :gift:**\n" +
                "Hey V+ players, we're going to be having a **MULTIDROP** event **TODAY** at <t:"+time+":f>. Please come online early and join the queue so you don't miss out on the loot! <@&909709653301157909>\n" +
                "\n**COUNTDOWN: <t:"+time+":R>**" +
                "\n> For those that don't know multidrops are an event where a bunch of loot drops are spawned a minute apart." +
                "\n> It’s often very chaotic and a bunch of players fight over the loot." +
                "\n> Loot drops are simply chests surrounded by 2 layers of crying obsidian.\n" +
                "https://cdn.discordapp.com/attachments/987080007832707132/1035575029842317424/unknown.png");

        sender.sendMessage("§a§lSUCCESS: §aMultidrop event scheduled for "+delay+" hours from now");


        SchedulerUtils.runLater(() -> {
            //run command as console
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "multidrop");
        }, 20 *60*60* delay);




        return true;
    }
}
