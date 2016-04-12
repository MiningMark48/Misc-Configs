package com.miningmark48.miscconfigs.event;

import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import com.miningmark48.miscconfigs.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;

public class EventSaplingGrowthMultiplier {

    @SubscribeEvent
    public void onSaplingGrowTreeEvent(SaplingGrowTreeEvent event)
    {
        if (ConfigurationHandler.saplingGrowthMultiplier > 1) {
            if (event.rand.nextInt(ConfigurationHandler.saplingGrowthMultiplier) != 0) {
                LogHelper.info("NO");
                event.setResult(Event.Result.DENY);
            }
        }else{
            LogHelper.info("YES");
            event.setResult(Event.Result.ALLOW);
        }
    }

}
