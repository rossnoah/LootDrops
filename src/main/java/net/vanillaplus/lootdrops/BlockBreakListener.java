package net.vanillaplus.lootdrops;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBeak(BlockBreakEvent e){
            if(Main.blocks.contains(e.getBlock())){
                e.setCancelled(true);
                    e.getPlayer().sendMessage("§cYou can't break lootdrop chests!");

            }
        }

    @EventHandler
    public void onBlockExplode(BlockExplodeEvent e){
        for(Block b:e.blockList()){
            if(Main.blocks.contains(b)){
                e.blockList().remove(b);
            }
        }
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e){
        for(Block b:e.blockList()){
            if(Main.blocks.contains(b)){
                e.blockList().remove(b);
            }
        }
    }


}
