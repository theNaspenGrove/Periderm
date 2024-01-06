package mov.naspen.periderm.helpers;

import org.bukkit.Material;
import org.bukkit.block.Block;

import static mov.naspen.periderm.Periderm.coreProtectHelper;

public class BlockManager {
    public static void setBlock(Block block, Material material, String user){
        block.setType(material);
        if(coreProtectHelper.isCoreProtectEnabled()){
            coreProtectHelper.getApi().logPlacement(user,block.getLocation(),block.getType(),block.getBlockData());
        }
    }
}
