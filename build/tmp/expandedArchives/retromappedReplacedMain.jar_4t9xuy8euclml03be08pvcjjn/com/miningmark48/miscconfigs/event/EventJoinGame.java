package com.miningmark48.miscconfigs.event;

import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import com.miningmark48.miscconfigs.reference.Reference;
import com.miningmark48.miscconfigs.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

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

            if (!e.player.func_130014_f_().field_72995_K) {

                NBTTagCompound tag = e.player.getEntityData();

                if (ConfigurationHandler.sendChatMessageOnce) {
                    if (tag.func_74779_i(Reference.MOD_ID + "doChatMessage") == "") {
                        tag.func_74778_a(Reference.MOD_ID + "doChatMessage", "send");
                    }
                    if (tag.func_74779_i(Reference.MOD_ID + "doChatMessage") == "send") {
                        sendChatMessage(e.player, message);
                        tag.func_74778_a(Reference.MOD_ID + "doChatMessage", "noSend");
                    }
                } else {
                    sendChatMessage(e.player, message);
                }

            }
        }
    }

    private void sendChatMessage(EntityPlayer player, String message){
        int color;
        if (ConfigurationHandler.doRandomColor){
            Random rand = new Random();
            color = rand.nextInt(4) + 1;
        }else{
            color = ConfigurationHandler.chatMessageColor;
        }
        if (color == 1) {
            player.func_146105_b(new TextComponentString(TextFormatting.RED + message));
        }else if (color == 2) {
            player.func_146105_b(new TextComponentString(TextFormatting.GREEN + message));
        }else if (color == 3) {
            player.func_146105_b(new TextComponentString(TextFormatting.BLUE + message));
        }else if (color == 4) {
            player.func_146105_b(new TextComponentString(TextFormatting.GOLD + message));
        }else{
            player.func_146105_b(new TextComponentString(message));
        }
    }

}
