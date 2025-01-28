package mov.naspen.periderm;

import mov.naspen.periderm.helpers.coreProtect.CoreProtectHelper;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Periderm extends JavaPlugin {
    public static CoreProtectHelper coreProtectHelper;
    public static Plugin plugin;
    @Override
    public void onEnable() {
        plugin = this;
        if(this.getServer().getPluginManager().isPluginEnabled("CoreProtect")){
            coreProtectHelper = CoreProtectHelper.getInstance();
            if(coreProtectHelper.isCoreProtectEnabled()){
                this.getLogger().log(java.util.logging.Level.INFO,"CoreProtect integration with Periderm is enabled!");
            }
        }
        this.getLogger().log(java.util.logging.Level.INFO, "May the Periderm protect you!");
    }
}

