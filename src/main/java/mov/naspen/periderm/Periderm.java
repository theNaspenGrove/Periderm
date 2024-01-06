package mov.naspen.periderm;

import org.bukkit.plugin.java.JavaPlugin;

public class Periderm extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getLogger().log(java.util.logging.Level.INFO, "May the Periderm protect you!");
    }
}

