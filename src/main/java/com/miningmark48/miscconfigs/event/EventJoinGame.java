package com.miningmark48.miscconfigs.event;

import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

import java.util.StringTokenizer;

public class EventJoinGame{

        @SubscribeEvent
        public void onJoin(PlayerEvent.PlayerLoggedInEvent e){

            if (!e.player.getEntityWorld().isRemote) {

                if (ConfigurationHandler.doChatMessage) {
                    if (ConfigurationHandler.chatMessageColor == 1) {
                        e.player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.RED + ConfigurationHandler.chatMessage));
                    }else if (ConfigurationHandler.chatMessageColor == 2) {
                        e.player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GREEN + ConfigurationHandler.chatMessage));
                    }else if (ConfigurationHandler.chatMessageColor == 3) {
                        e.player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.BLUE + ConfigurationHandler.chatMessage));
                    }else if (ConfigurationHandler.chatMessageColor == 4) {
                        e.player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + ConfigurationHandler.chatMessage));
                    }else{
                        e.player.addChatComponentMessage(new ChatComponentTranslation(ConfigurationHandler.chatMessage));
                    }
                }
            }
        }

}
