package mov.naspen.periderm;

import mov.naspen.periderm.helpers.coreProtect.CoreProtectHelper;
import org.bukkit.plugin.java.JavaPlugin;

public class Periderm extends JavaPlugin {
    public static CoreProtectHelper coreProtectHelper;
    @Override
    public void onEnable() {
        coreProtectHelper = new CoreProtectHelper();
        if(coreProtectHelper.isCoreProtectEnabled()){
            this.getLogger().log(java.util.logging.Level.INFO,"CoreProtect integration with Periderm is enabled!");
        }
        this.getLogger().log(java.util.logging.Level.INFO, "May the Periderm protect you!");
    }
}

