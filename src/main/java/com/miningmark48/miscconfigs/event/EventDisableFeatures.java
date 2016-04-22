package com.miningmark48.miscconfigs.event;

import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class EventDisableFeatures {

    @SubscribeEvent
    public void playerInteract(PlayerInteractEvent event){
        if(event.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)) {
            if (ConfigurationHandler.craftingTables) {
                if (event.world.getBlock(event.x, event.y, event.z).equals(Blocks.crafting_table)) {
                    event.setCanceled(true);
                    event.entityPlayer.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("chat.event.noWorkbench")));
                }
            }
            if(ConfigurationHandler.enchanting){
                if (event.world.getBlock(event.x, event.y, event.z).equals(Blocks.enchanting_table)) {
                    event.setCanceled(true);
                    event.entityPlayer.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("chat.event.noEnchanting")));
                }
            }
        }
    }
}
