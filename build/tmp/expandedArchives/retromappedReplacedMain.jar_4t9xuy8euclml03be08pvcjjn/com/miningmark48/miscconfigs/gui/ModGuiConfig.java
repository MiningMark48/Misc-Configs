package com.miningmark48.miscconfigs.gui;

import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import com.miningmark48.miscconfigs.reference.Reference;
import com.miningmark48.miscconfigs.utility.Translate;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import scala.actors.threadpool.Arrays;

import java.util.Locale;

public class ModGuiConfig extends GuiConfig {

    public ModGuiConfig(GuiScreen guiScreen){
        super(guiScreen,
                Arrays.asList(new IConfigElement[]{
                    new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)),
                    new ConfigElement(ConfigurationHandler.configuration.getCategory(Translate.translateToLocal("config.category.chatMessage.title").toLowerCase())),
                    new ConfigElement(ConfigurationHandler.configuration.getCategory(Translate.translateToLocal("config.category.disableFeatures.title").toLowerCase())),
                    new ConfigElement(ConfigurationHandler.configuration.getCategory(Translate.translateToLocal("config.category.windowName.title").toLowerCase()))
                }),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }

}
