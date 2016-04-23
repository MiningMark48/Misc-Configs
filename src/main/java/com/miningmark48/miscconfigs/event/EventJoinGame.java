package com.miningmark48.miscconfigs.event;

import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import com.miningmark48.miscconfigs.reference.Reference;
import com.miningmark48.miscconfigs.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

import java.util.Random;

public class EventJoinGame{

    @SubscribeEvent
    public void onJoin(PlayerEvent.PlayerLoggedInEvent e){

        if (ConfigurationHandler.doChatMessage) {
            Random rand = new Random();
            String message;

            if (ConfigurationHandler.doRandomMessage) {
                message = ConfigurationHandler.chatMessage[rand.nextInt(ConfigurationHandler.chatMessage.length)];
            } else {
                message = ConfigurationHandler.chatMessage[0];
            }

            if (!e.player.getEntityWorld().isRemote) {

                NBTTagCompound tag = e.player.getEntityData();

                if (ConfigurationHandler.sendChatMessageOnce) {
                    if (tag.getString(Reference.MOD_ID + "doChatMessage") == "") {
                        tag.setString(Reference.MOD_ID + "doChatMessage", "send");
                    }
                    if (tag.getString(Reference.MOD_ID + "doChatMessage") == "send") {
                        sendChatMessage(e.player, message);
                        tag.setString(Reference.MOD_ID + "doChatMessage", "noSend");
                    }
                } else {
                    sendChatMessage(e.player, message);
                }

            }
        }
    }

    private void sendChatMessage(EntityPlayer player, String message){
        if (ConfigurationHandler.chatMessageColor == 1) {
            player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.RED + message));
        }else if (ConfigurationHandler.chatMessageColor == 2) {
            player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GREEN + message));
        }else if (ConfigurationHandler.chatMessageColor == 3) {
            player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.BLUE + message));
        }else if (ConfigurationHandler.chatMessageColor == 4) {
            player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + message));
        }else{
            player.addChatComponentMessage(new ChatComponentTranslation(message));
        }
    }

}
