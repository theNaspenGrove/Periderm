package mov.naspen.periderm.loging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AspenLogHelper {

    public Logger logger;
    public String LoggerName;

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
