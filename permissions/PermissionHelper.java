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

    public boolean hasPermission(Player p, Perm perm){
        if(p.hasPermission(topLevelPermissionNode + perm.getPermissionNode())){
            return true;
        }
        chatHelper.sendChat(p,perm.hasMessage() ? perm.getDenyMessage() : this.getDefaultDenyMessage());
        return false;
    }

    public PredefinedMessage getDefaultDenyMessage() {
        return defaultDenyMessage;
    }
}
