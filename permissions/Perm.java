package net.mov51.periderm.paper.permissions;

import net.mov51.periderm.paper.chat.PredefinedMessage;

public class Perm {
    private final String permissionNode;
    private final PredefinedMessage denyMessage;
    private final String command;
    private final String commandHelp;

    public Perm(String permissionNode, PredefinedMessage denyMessage, String command, String commandHelp){
        this.permissionNode = permissionNode;
        this.denyMessage = denyMessage;
        this.command = command;
        this.commandHelp = commandHelp;
    }

    public Perm(String permissionNode, PredefinedMessage denyMessage, String command){
        this.permissionNode = permissionNode;
        this.denyMessage = denyMessage;
        this.command = command;
        this.commandHelp = null;
    }

    public Perm(String permissionNode){
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
