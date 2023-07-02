package net.mov51.periderm.permissions;

import net.mov51.periderm.chat.PredefinedMessage;

public class PermItem {
    private final String permissionNode;
    private final PredefinedMessage denyMessage;
    private final String command;
    private final String commandHelp;

    public PermItem(String permissionNode, PredefinedMessage denyMessage, String command, String commandHelp){
        this.permissionNode = permissionNode;
        this.denyMessage = denyMessage;
        this.command = command;
        this.commandHelp = commandHelp;
    }

    public PermItem(String permissionNode, PredefinedMessage denyMessage, String command){
        this.permissionNode = permissionNode;
        this.denyMessage = denyMessage;
        this.command = command;
        this.commandHelp = null;
    }

    public PermItem(String permissionNode){
        this.permissionNode = permissionNode;
        this.denyMessage = null;
        this.command = null;
        this.commandHelp = null;
    }

    public boolean hasCommandHelp() {
        return this.commandHelp != null;
    }

    public String getCommandHelp() {
        return this.commandHelp;
    }

    public boolean hasCommand() {
        return this.commandHelp != null;
    }

    public String getCommand() {
        return this.command;
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
