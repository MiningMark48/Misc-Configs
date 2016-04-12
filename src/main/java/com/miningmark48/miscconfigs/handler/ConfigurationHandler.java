package com.miningmark48.miscconfigs.handler;

import com.miningmark48.miscconfigs.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;
import java.util.Locale;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static boolean craftingTables;
    public static boolean doChatMessage;
    public static boolean sendChatMessageOnce;
    public static String chatMessage;
    public static int chatMessageColor;
    public static int saplingGrowthMultiplier;

    public static void init(File configFile){

        //Create the configuration object from the given configuration file
        if (configuration == null){
            configuration = new Configuration(configFile);
            loadConfiguration();
        }

    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){

        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            loadConfiguration();
        }

    }

    private static void loadConfiguration(){

        configuration.addCustomCategoryComment(StatCollector.translateToLocal("config.category.chatMessage.title"), StatCollector.translateToLocal("config.category.chatMessage.desc"));

        craftingTables = configuration.getBoolean(StatCollector.translateToLocal("config.craftingTables.title"), Configuration.CATEGORY_GENERAL, false, StatCollector.translateToLocal("config.craftingTables.desc"));
        doChatMessage = configuration.getBoolean(StatCollector.translateToLocal("config.doChatMessage.title"), StatCollector.translateToLocal("config.category.chatMessage.title"), true, StatCollector.translateToLocal("config.doChatMessage.desc"));
        sendChatMessageOnce = configuration.getBoolean(StatCollector.translateToLocal("config.sendChatMessageOnce.title"), StatCollector.translateToLocal("config.category.chatMessage.title"), false, StatCollector.translateToLocal("config.sendChatMessageOnce.desc"));
        chatMessage = configuration.getString(StatCollector.translateToLocal("config.chatMessage.title"), StatCollector.translateToLocal("config.category.chatMessage.title"), StatCollector.translateToLocal("config.chatMessage.default"), StatCollector.translateToLocal("config.chatMessage.desc"));
        chatMessageColor = configuration.getInt(StatCollector.translateToLocal("config.chatMessageColor.title"), StatCollector.translateToLocal("config.category.chatMessage.title"), 4, 0, 4, StatCollector.translateToLocal("config.chatMessageColor.desc"));
        saplingGrowthMultiplier = configuration.getInt(StatCollector.translateToLocal("config.saplingGrowthMultiplier.title"), Configuration.CATEGORY_GENERAL, 100000, 0, Integer.MAX_VALUE, StatCollector.translateToLocal("config.saplingGrowthMultiplier.desc"));

        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
