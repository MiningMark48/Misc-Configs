package com.miningmark48.miscconfigs.event;

import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import com.miningmark48.miscconfigs.utility.Translate;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventDisableFeatures {

    @SubscribeEvent
    public void playerInteract(PlayerInteractEvent event){
        if (ConfigurationHandler.disable_craftingTables) {
            if (event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.CRAFTING_TABLE)) {
                event.setCanceled(true);
                if (!event.getWorld().isRemote) {
                    event.getEntityPlayer().addChatComponentMessage(new TextComponentString(TextFormatting.DARK_RED + Translate.translateToLocal("chat.event.noWorkbench")));
                }
            }
        }
        if(ConfigurationHandler.disable_enchanting){
            if (event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.ENCHANTING_TABLE)) {
                event.setCanceled(true);
                if (!event.getWorld().isRemote) {
                    event.getEntityPlayer().addChatComponentMessage(new TextComponentString(TextFormatting.DARK_RED + Translate.translateToLocal("chat.event.noEnchanting")));
                }
            }
        }
        if(ConfigurationHandler.disable_chests){
            if (event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.CHEST) || event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.TRAPPED_CHEST)) {
                event.setCanceled(true);
                if (!event.getWorld().isRemote) {
                    event.getEntityPlayer().addChatComponentMessage(new TextComponentString(TextFormatting.DARK_RED + Translate.translateToLocal("chat.event.no_chest")));
                }
            }
        }
        if(ConfigurationHandler.disable_furnaces){
            if (event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.FURNACE)) {
                event.setCanceled(true);
                if (!event.getWorld().isRemote) {
                    event.getEntityPlayer().addChatComponentMessage(new TextComponentString(TextFormatting.DARK_RED + Translate.translateToLocal("chat.event.no_furnace")));
                }
            }
        }
    }
}
