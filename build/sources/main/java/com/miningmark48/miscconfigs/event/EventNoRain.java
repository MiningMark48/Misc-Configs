package com.miningmark48.miscconfigs.event;

import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import com.miningmark48.miscconfigs.utility.LogHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
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
