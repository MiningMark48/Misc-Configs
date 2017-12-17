package com.miningmark48.miscconfigs;

import com.miningmark48.miscconfigs.config.ConfigWindowName;
import com.miningmark48.miscconfigs.event.EventDisableFeatures;
import com.miningmark48.miscconfigs.event.EventJoinGame;
import com.miningmark48.miscconfigs.event.EventNoRain;
import com.miningmark48.miscconfigs.event.EventSaplingGrowthMultiplier;
import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import com.miningmark48.miscconfigs.proxy.ClientProxy;
import com.miningmark48.miscconfigs.proxy.IProxy;
import com.miningmark48.miscconfigs.reference.Reference;
import com.miningmark48.miscconfigs.utility.LogHelper;
import com.miningmark48.miscconfigs.utility.Translate;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid= Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class MiscConfigs {

    @Mod.Instance(Reference.MOD_ID)
    public static MiscConfigs instance;

    @SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;
    public static ClientProxy cProxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
        ConfigWindowName.setWindowName();
        //LogHelper.info(Translate.translateToLocal("log.info.preinit"));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new EventDisableFeatures());
        MinecraftForge.EVENT_BUS.register(new EventJoinGame());
        MinecraftForge.EVENT_BUS.register(new EventNoRain());
        //LogHelper.info(Translate.translateToLocal( "log.info.init"));
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new EventSaplingGrowthMultiplier());
        //LogHelper.info(Translate.translateToLocal("log.info.postinit"));
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event){
    }

}
