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
            if (event.getWorld().func_180495_p(event.getPos()).func_177230_c().equals(Blocks.field_150462_ai)) {
                event.setCanceled(true);
                if (!event.getWorld().field_72995_K) {
                    event.getEntityPlayer().func_146105_b(new TextComponentString(TextFormatting.DARK_RED + Translate.translateToLocal("chat.event.noWorkbench")));
                }
            }
        }
        if(ConfigurationHandler.enchanting){
            if (event.getWorld().func_180495_p(event.getPos()).func_177230_c().equals(Blocks.field_150381_bn)) {
                event.setCanceled(true);
                if (!event.getWorld().field_72995_K) {
                    event.getEntityPlayer().func_146105_b(new TextComponentString(TextFormatting.DARK_RED + Translate.translateToLocal("chat.event.noEnchanting")));
                }
            }
        }
    }
}
