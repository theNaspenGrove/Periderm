package mov.naspen.periderm.loging;

import net.mov51.periderm.configuration.ConfigHelper;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AspenLogHelper {

    public Logger logger;
    public String LoggerName;
    private ConfigHelper config;

    public AspenLogHelper(Logger logger, String name, ConfigHelper config){
        this.logger = logger;
        this.LoggerName = name;
        this.config = config;
        config.newConfigItem("debug", false);
    }

    public void sendLogDebug(String[] logs){
        if(!(boolean) config.getValue("debug"))
            return;
        sendLogDebug("--" + LoggerName + " --");
        for (String log : logs)
        {
            sendLogDebug(log);
        }
    }
    public void sendLogDebug(String log){
        if((boolean) config.getValue("debug"))
            logger.log(Level.INFO, "[DEBUG] " + log);
    }

    public void sendLogInfo(String[] logs){
        logger.log(Level.WARNING, " --" + LoggerName + " --");
        for (String log : logs)
        {
            sendLogInfo(log);
        }
    }

    public void sendLogInfo(String log){
        logger.log(Level.INFO, " " + log);
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
