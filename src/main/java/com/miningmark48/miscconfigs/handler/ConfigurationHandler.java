package com.miningmark48.miscconfigs.handler;

import com.miningmark48.miscconfigs.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static boolean craftingTables;
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

        craftingTables = configuration.getBoolean(StatCollector.translateToLocal("config.craftingTables.title"), Configuration.CATEGORY_GENERAL, false, StatCollector.translateToLocal("config.craftingTables.desc"));
        saplingGrowthMultiplier = configuration.getInt(StatCollector.translateToLocal("config.saplingGrowthMultiplier.title"), Configuration.CATEGORY_GENERAL, 0, 0, Integer.MAX_VALUE, StatCollector.translateToLocal("config.saplingGrowthMultiplier.desc"));

        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
