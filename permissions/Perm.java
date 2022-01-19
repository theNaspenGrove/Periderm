package net.mov51.periderm.paper.permissions;

import net.mov51.periderm.paper.chat.PredefinedMessage;

public class Perm {
    private final PredefinedMessage denyMessage;
    private final String permissionNode;
    private final String commandHelp;

    public Perm(String permissionNode, PredefinedMessage denyMessage, String commandHelp){
        this.denyMessage = denyMessage;
        this.permissionNode = permissionNode;
        this.commandHelp = commandHelp;
    }

    public Perm(String permissionNode, PredefinedMessage denyMessage){
        this.denyMessage = denyMessage;
        this.permissionNode = permissionNode;
        this.commandHelp = null;
    }

    public Perm(String permissionNode){
        this.denyMessage = null;
        this.permissionNode = permissionNode;
        this.commandHelp = null;
    }

    public boolean hasCommandHelp() {
        return this.commandHelp != null;
    }

    public String getCommandHelp() {
        return this.commandHelp;
    }

    public boolean hasMessage() {
        return this.denyMessage != null;
    }

    public PredefinedMessage getDenyMessage() {
        return denyMessage;
    }

    public String getPermissionNode() {
        return permissionNode;
    }
}
