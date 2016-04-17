package com.miningmark48.miscconfigs.event;


import com.miningmark48.miscconfigs.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class EventSaplingGrowthMultiplier {

    @SubscribeEvent
    public void onSaplingGrowTreeEvent(TickEvent.WorldTickEvent event)
    {
        //LogHelper.info("GROW");
    }

}
