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
        if (ConfigurationHandler.craftingTables) {
            if (event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.CRAFTING_TABLE)) {
                event.setCanceled(true);
                if (!event.getWorld().isRemote) {
                    event.getEntityPlayer().addChatComponentMessage(new TextComponentString(TextFormatting.DARK_RED + Translate.translateToLocal("chat.event.noWorkbench")));
                }
            }
        }
        if(ConfigurationHandler.enchanting){
            if (event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.ENCHANTING_TABLE)) {
                event.setCanceled(true);
                if (!event.getWorld().isRemote) {
                    event.getEntityPlayer().addChatComponentMessage(new TextComponentString(TextFormatting.DARK_RED + Translate.translateToLocal("chat.event.noEnchanting")));
                }
            }
        }
    }
}
