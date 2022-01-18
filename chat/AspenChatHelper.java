package net.mov51.periderm.paper.chat;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;

public class AspenChatHelper {

    ChatPrefix chatPrefix;

    public AspenChatHelper(String prefix){
         chatPrefix = new ChatPrefix(prefix + " ");
    }

    public void sendChat(Player p, String message){
        p.sendMessage(Component.text()
                .append(chatPrefix.getComponent()).append(LegacyComponentSerializer.legacyAmpersand().deserialize(message))
                .build());
    }

    public void sendChat(Player p, String[] messages){
        for (String message: messages) {
            p.sendMessage(Component.text()
                    .append(chatPrefix.getComponent()).append(LegacyComponentSerializer.legacyAmpersand().deserialize(message))
                    .build());
        }
    }

    public void sendChat(Player p, TextComponent message){
        p.sendMessage(Component.text()
                .append(chatPrefix.getComponent()).append(message)
                .build());
    }

    public TextComponent buildRunCommandComponent(String message, String command){
        return LegacyComponentSerializer.legacyAmpersand().deserialize(message)
                .clickEvent(ClickEvent.runCommand(command));
    }

    public TextComponent buildSuggestCommandComponent(String message, String command){
        return LegacyComponentSerializer.legacyAmpersand().deserialize(message)
                .clickEvent(ClickEvent.suggestCommand(command));
    }

    public void sendBarMessage(Player p){
        this.sendChat(p,Component.text()
                .content(StringUtils.center("-----",53))
                .build());
    }
}
