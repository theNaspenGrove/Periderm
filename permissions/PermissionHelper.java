package net.mov51.periderm.paper.permissions;

import net.mov51.periderm.paper.chat.PredefinedMessage;
import org.bukkit.entity.Player;

import static net.mov51.aspenprefix.AspenPrefix.chatHelper;

public class PermissionHelper {

    private final String topLevelPermissionNode;
    private final PredefinedMessage defaultDenyMessage;


    public PermissionHelper(String topLevelPermissionNode, PredefinedMessage defaultDenyMessage){
        this.topLevelPermissionNode = topLevelPermissionNode;
        this.defaultDenyMessage = defaultDenyMessage;
    }

    public boolean hasPermission(Player p, Perm perm, boolean silent){
        if(p.hasPermission(topLevelPermissionNode + perm.getPermissionNode())){
            return true;
        }
        if(silent){
            return false;
        }
        chatHelper.sendChat(p,perm.hasMessage() ? perm.getDenyMessage() : this.getDefaultDenyMessage());
        return false;
    }

    public boolean hasPermission(Player p, Perm perm){
        return hasPermission(p,perm,false);

    }


    public PredefinedMessage getDefaultDenyMessage() {
        return defaultDenyMessage;
    }
}
