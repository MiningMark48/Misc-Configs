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
            if (event.world.func_72912_H().func_76059_o()) {
                LogHelper.info("RAIN GO AWAY");
                event.world.func_72912_H().func_76084_b(false);
            }
        }
    }

}
