package net.mov51.periderm.helpers.permissions;

import net.mov51.periderm.chat.AspenChatHelper;
import net.mov51.periderm.chat.PredefinedMessage;
import org.bukkit.entity.Player;

public class PermissionHelper {

    private final String topLevelPermissionNode;
    private final PredefinedMessage defaultDenyMessage;
    private final AspenChatHelper chatHelper;


    public PermissionHelper(String topLevelPermissionNode, PredefinedMessage defaultDenyMessage, AspenChatHelper chatHelper){
        this.topLevelPermissionNode = topLevelPermissionNode;
        this.defaultDenyMessage = defaultDenyMessage;
        this.chatHelper = chatHelper;
    }

    public boolean hasPermission(Player p, PermItem perm, boolean silent){
        if(p.hasPermission(topLevelPermissionNode + perm.getPermissionNode())){
            return true;
        }
        if(silent){
            return false;
        }
        chatHelper.sendChat(p,perm.hasMessage() ? perm.getDenyMessage() : this.getDefaultDenyMessage());
        return false;
    }

    public boolean hasPermission(Player p, PermItem perm){
        return hasPermission(p,perm,false);

    }


    public PredefinedMessage getDefaultDenyMessage() {
        return defaultDenyMessage;
    }
}
