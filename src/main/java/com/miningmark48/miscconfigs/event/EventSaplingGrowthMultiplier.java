package com.miningmark48.miscconfigs.event;

import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import com.miningmark48.miscconfigs.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;

public class EventSaplingGrowthMultiplier {

    @Mod.EventHandler
    public void onSaplingGrowTreeEvent(SaplingGrowTreeEvent event)
    {
        LogHelper.info("TREE GROW: ");
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
