package com.miningmark48.miscconfigs.event;

import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import com.miningmark48.miscconfigs.reference.Reference;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

public class EventJoinGame{

    @SubscribeEvent
    public void onJoin(PlayerEvent.PlayerLoggedInEvent e){

        if (!e.player.getEntityWorld().isRemote) {

            NBTTagCompound tag = e.player.getEntityData();

            if(tag.getString(Reference.MOD_ID + "doChatMessage") == "") {
                tag.setString(Reference.MOD_ID + "doChatMessage", "send");
            }

            if (ConfigurationHandler.sendChatMessageOnce) {
                if (tag.getString(Reference.MOD_ID + "doChatMessage") == "send") {
                    sendChatMessage(e.player);
                    tag.setString(Reference.MOD_ID + "doChatMessage", "noSend");
                }
            }else{
                sendChatMessage(e.player);
            }

        }
    }

    private void sendChatMessage(EntityPlayer player){
        if (ConfigurationHandler.doChatMessage) {
            if (ConfigurationHandler.chatMessageColor == 1) {
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.RED + ConfigurationHandler.chatMessage));
            }else if (ConfigurationHandler.chatMessageColor == 2) {
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GREEN + ConfigurationHandler.chatMessage));
            }else if (ConfigurationHandler.chatMessageColor == 3) {
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.BLUE + ConfigurationHandler.chatMessage));
            }else if (ConfigurationHandler.chatMessageColor == 4) {
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + ConfigurationHandler.chatMessage));
            }else{
                player.addChatComponentMessage(new ChatComponentTranslation(ConfigurationHandler.chatMessage));
            }
        }
    }

}
