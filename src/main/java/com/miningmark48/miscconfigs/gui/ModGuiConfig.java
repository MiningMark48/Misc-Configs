package com.miningmark48.miscconfigs.gui;

import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import com.miningmark48.miscconfigs.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import scala.actors.threadpool.Arrays;

import java.util.Locale;

public class ModGuiConfig extends GuiConfig{

    public ModGuiConfig(GuiScreen guiScreen){
        super(guiScreen,
                Arrays.asList(new IConfigElement[]{
                    new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)),
                    new ConfigElement(ConfigurationHandler.configuration.getCategory(StatCollector.translateToLocal("config.category.chatMessage.title").toLowerCase())),
                    new ConfigElement(ConfigurationHandler.configuration.getCategory(StatCollector.translateToLocal("config.category.disableFeatures.title").toLowerCase()))
                }),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }

}
