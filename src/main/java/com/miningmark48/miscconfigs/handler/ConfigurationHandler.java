package com.miningmark48.miscconfigs.handler;

import com.miningmark48.miscconfigs.reference.Reference;
import com.miningmark48.miscconfigs.utility.Translate;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;

    //Disable
    public static boolean disable_craftingTables;
    public static boolean disable_enchanting;
    public static boolean disable_chests;
    public static boolean disable_furnaces;

    public static boolean doChatMessage;
    public static boolean sendChatMessageOnce;
    public static boolean noRain;
    public static boolean doRandomMessage;
    public static boolean doRandomColor;
    public static boolean setWindowName;
    public static String[] chatMessage;
    public static String windowName;
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

        if (event.getModID().equalsIgnoreCase(Reference.MOD_ID)){
            loadConfiguration();
        }

    }

    private static void loadConfiguration(){

        configuration.addCustomCategoryComment(Translate.translateToLocal("config.category.chatMessage.title"), Translate.translateToLocal("config.category.chatMessage.desc"));
        configuration.addCustomCategoryComment(Translate.translateToLocal("config.category.disableFeatures.title"), Translate.translateToLocal("config.category.disableFeatures.desc"));
        configuration.addCustomCategoryComment(Translate.translateToLocal("config.category.toolValues.title"), Translate.translateToLocal("config.category.toolValues.desc"));
        configuration.addCustomCategoryComment(Translate.translateToLocal("config.category.weaponValues.title"), Translate.translateToLocal("config.category.weaponValues.desc"));
        configuration.addCustomCategoryComment(Translate.translateToLocal("config.category.windowName.title"), Translate.translateToLocal("config.category.windowName.desc"));

        configuration.setCategoryRequiresMcRestart(Translate.translateToLocal("config.category.windowName.title"), true);

        noRain = configuration.getBoolean(Translate.translateToLocal("config.noRain.title"), Configuration.CATEGORY_GENERAL, false, Translate.translateToLocal("config.noRain.desc"));
        saplingGrowthMultiplier = configuration.getInt(Translate.translateToLocal("config.saplingGrowthMultiplier.title"), Configuration.CATEGORY_GENERAL, 0, 0, Integer.MAX_VALUE, Translate.translateToLocal("config.saplingGrowthMultiplier.desc"));

        //Chat Message
        doChatMessage = configuration.getBoolean(Translate.translateToLocal("config.doChatMessage.title"), Translate.translateToLocal("config.category.chatMessage.title"), true, Translate.translateToLocal("config.doChatMessage.desc"));
        sendChatMessageOnce = configuration.getBoolean(Translate.translateToLocal("config.sendChatMessageOnce.title"), Translate.translateToLocal("config.category.chatMessage.title"), false, Translate.translateToLocal("config.sendChatMessageOnce.desc"));
        doRandomMessage = configuration.getBoolean(Translate.translateToLocal("config.doRandomMessage.title"), Translate.translateToLocal("config.category.chatMessage.title"), false, Translate.translateToLocal("config.doRandomMessage.desc"));
        doRandomColor = configuration.getBoolean(Translate.translateToLocal("config.doRandomColor.title"), Translate.translateToLocal("config.category.chatMessage.title"), true, Translate.translateToLocal("config.doRandomColor.desc"));
        chatMessage = configuration.getStringList(Translate.translateToLocal("config.chatMessage.title"), Translate.translateToLocal("config.category.chatMessage.title"), new String[]{Translate.translateToLocal("config.chatMessage.default")}, Translate.translateToLocal("config.chatMessage.desc"));
        chatMessageColor = configuration.getInt(Translate.translateToLocal("config.chatMessageColor.title"), Translate.translateToLocal("config.category.chatMessage.title"), 4, 0, 4, Translate.translateToLocal("config.chatMessageColor.desc"));

        //Disable Features
        disable_craftingTables = configuration.getBoolean(Translate.translateToLocal("config.disable_crafting_tables.title"), Translate.translateToLocal("config.category.disableFeatures.title"), false, Translate.translateToLocal("config.disable_crafting_tables.desc"));
        disable_enchanting = configuration.getBoolean(Translate.translateToLocal("config.disable_enchanting.title"), Translate.translateToLocal("config.category.disableFeatures.title"), false, Translate.translateToLocal("config.disable_enchanting.desc"));
        disable_chests = configuration.getBoolean(Translate.translateToLocal("config.disable_chests.title"), Translate.translateToLocal("config.category.disableFeatures.title"), false, Translate.translateToLocal("config.disable_chests.desc"));
        disable_furnaces = configuration.getBoolean(Translate.translateToLocal("config.disable_furnace.title"), Translate.translateToLocal("config.category.disableFeatures.title"), false, Translate.translateToLocal("config.disable_furnace.desc"));

        //Window Name
        setWindowName = configuration.getBoolean(Translate.translateToLocal("config.setWindowName.title"), Translate.translateToLocal("config.category.windowName.title"), false, Translate.translateToLocal("config.setWindowName.desc"));
        windowName = configuration.getString(Translate.translateToLocal("config.windowName.title"), Translate.translateToLocal("config.category.windowName.title"), new String(Translate.translateToLocal("config.windowName.default")), Translate.translateToLocal("config.windowName.desc"));


        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
