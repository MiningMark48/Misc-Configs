package com.miningmark48.miscconfigs;

import com.miningmark48.miscconfigs.event.EventCraftingTable;
import com.miningmark48.miscconfigs.event.EventJoinGame;
import com.miningmark48.miscconfigs.event.EventSaplingGrowthMultiplier;
import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import com.miningmark48.miscconfigs.proxy.ClientProxy;
import com.miningmark48.miscconfigs.proxy.IProxy;
import com.miningmark48.miscconfigs.reference.Reference;
import com.miningmark48.miscconfigs.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;

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
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        LogHelper.info(StatCollector.translateToLocal("log.info.preinit"));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new EventCraftingTable());
        MinecraftForge.EVENT_BUS.register(new EventJoinGame());

        LogHelper.info(StatCollector.translateToLocal( "log.info.init"));
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new EventSaplingGrowthMultiplier());
        LogHelper.info(StatCollector.translateToLocal("log.info.postinit"));
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event){
    }

}
