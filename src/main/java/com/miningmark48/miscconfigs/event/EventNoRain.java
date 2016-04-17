package com.miningmark48.miscconfigs.event;

import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import com.miningmark48.miscconfigs.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import sun.rmi.runtime.Log;

public class EventNoRain {

    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent event){
        if(ConfigurationHandler.noRain) {
            if (event.world.getWorldInfo().isRaining()) {
                LogHelper.info("RAIN GO AWAY");
                event.world.getWorldInfo().setRaining(false);
            }
        }
    }

}
