package com.miningmark48.miscconfigs.event;


import com.miningmark48.miscconfigs.utility.LogHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventSaplingGrowthMultiplier {

    @SubscribeEvent
    public void onSaplingGrowTreeEvent(TickEvent.WorldTickEvent event)
    {
        //LogHelper.info("GROW");
    }

}
