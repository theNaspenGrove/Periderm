package net.mov51.periderm.paper.chat;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.entity.Player;

public class AspenChatHelper {

    ChatPrefix chatPrefix;

    public AspenChatHelper(String prefix){
         chatPrefix = new ChatPrefix(prefix);
    }

    public void sendChat(Player p, String message){
        p.sendMessage(Component.text().append(chatPrefix.getComponent()).append(Component.text().content(message)).build());
    }

    public void sendChat(Player p, String[] messages){
        for (String message: messages) {
            p.sendMessage(Component.text().append(chatPrefix.getComponent()).append(Component.text().content(message)).build());
        }
    }

    public void sendChat(Player p, TextComponent message){
        p.sendMessage(Component.text().append(chatPrefix.getComponent()).append(message).build());
    }
}
