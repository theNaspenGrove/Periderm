package mov.naspen.periderm.helpers.coreProtect;

import net.coreprotect.CoreProtect;
import net.coreprotect.CoreProtectAPI;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;

import static mov.naspen.periderm.Periderm.plugin;
import static org.bukkit.Bukkit.getServer;

public class CoreProtectHelper {

    private static CoreProtectHelper instance = null;
    CoreProtectAPI api;

    private CoreProtectHelper(){
        Plugin CO = getServer().getPluginManager().getPlugin("CoreProtect");
        if (!(CO instanceof CoreProtect)) {
            plugin.getLogger().log(Level.WARNING,"CoreProtect not found");
            return;
        }
        this.api = ((CoreProtect) CO).getAPI();
        if(this.api == null){
            plugin.getLogger().log(Level.WARNING,"CoreProtect API not found");
        }
        if(this.api.isEnabled()){
            plugin.getLogger().log(Level.WARNING,"CoreProtect enabled");
        }
        if(this.api.APIVersion() < 10){
            plugin.getLogger().log(Level.WARNING,"CoreProtectAPI version " + this.api.APIVersion() + " not compatible");
        }
    }

    public static CoreProtectHelper getInstance(){
        if(instance == null){
            instance = new CoreProtectHelper();
        }
        return instance;
    }

    public boolean isCoreProtectEnabled(){
        return this.api.isEnabled();
    }

    public void setBlock(Block block, Material material, String user){
        if(this.isCoreProtectEnabled()){
            this.api.logRemoval(user, block.getLocation(), block.getType(), block.getBlockData());
        }
        block.setType(material);
    }
}
