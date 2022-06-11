package net.mov51.periderm.logs;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AspenLogHelper {

    public Logger logger;
    public String LoggerName;

    public AspenLogHelper(Logger logger, String name){
        this.logger = logger;
        this.LoggerName = name;
    }

    public void sendLogInfo(String[] logs){
        logger.log(Level.WARNING, " --" + LoggerName + " --");
        for (String log : logs)
        {
            sendLogInfo(log);
        }
    }

    public void sendLogInfo(String info){
        logger.log(Level.INFO, " " + info);
    }

    public void sendLogWarning(String[] logs){
        logger.log(Level.WARNING, " --" + LoggerName + " Warning--");
        for (String log : logs)
        {
            sendLogWarning(log);
        }
    }

    public void sendLogWarning(String log){
        logger.log(Level.WARNING, " " + log);
    }


    public void sendLogSevere(String[] logs){
        logger.log(Level.WARNING, " --" + LoggerName + " Severe--");
        for (String log : logs)
        {
            sendLogSevere(log);
        }
    }

    public void sendLogSevere(String log){
        logger.log(Level.SEVERE, " " + log);
    }

}
