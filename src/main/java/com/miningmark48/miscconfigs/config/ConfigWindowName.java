package com.miningmark48.miscconfigs.config;

import com.miningmark48.miscconfigs.handler.ConfigurationHandler;
import org.lwjgl.opengl.Display;

public class ConfigWindowName {

    public static void setWindowName(){
        if(ConfigurationHandler.setWindowName){
            Display.setTitle(ConfigurationHandler.windowName);
        }
    }

}
