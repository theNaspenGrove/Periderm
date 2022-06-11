package net.mov51.periderm.paper.chat;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Color;
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

    public void sendChat(Player p, PredefinedMessage message){
        p.sendMessage(message.getMessage());
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

    //Default - Underlined & Dark Aqua
    public TextComponent buildRunCommandComponent(String message, String command){
        return buildRunCommandComponent(message,command,true);
    }

    //Underlined & custom color
    public TextComponent buildRunCommandComponent(String message, String command, NamedTextColor color){
        return buildRunCommandComponent(message,command,true,color);
    }

    //Optionally underlined & Dark Aqua
    public TextComponent buildRunCommandComponent(String message, String command, boolean underlined){
        return buildRunCommandComponent (message, command, underlined,NamedTextColor.DARK_AQUA);
    }

    //optionally underlined & custom color
    public TextComponent buildRunCommandComponent(String message, String command, boolean underlined, NamedTextColor color){

        TextComponent out = LegacyComponentSerializer.legacyAmpersand().deserialize(message)
                .clickEvent(ClickEvent.runCommand(command))
                .decoration(TextDecoration.UNDERLINED,underlined);
        if(color != null){
            out = out.color(TextColor.color(color));
        }
        return out;
    }


    //Default - Underlined & Dark Aqua
    public TextComponent buildSuggestCommandComponent(String message, String command){
        return buildSuggestCommandComponent(message,command,true);
    }

    //Underlined & custom color
    public TextComponent buildSuggestCommandComponent(String message, String command,NamedTextColor color){
        return buildSuggestCommandComponent(message,command,true,color);
    }

    //Optionally underlined & Dark Aqua
    public TextComponent buildSuggestCommandComponent(String message, String command,boolean underlined){
        return buildSuggestCommandComponent(message,command,underlined,NamedTextColor.DARK_AQUA);
    }

    //optionally underlined & custom color
    public TextComponent buildSuggestCommandComponent(String message, String command,boolean underlined,NamedTextColor color){
        TextComponent out = LegacyComponentSerializer.legacyAmpersand().deserialize(message)
                .clickEvent(ClickEvent.suggestCommand(command))
                .decoration(TextDecoration.UNDERLINED,underlined);
        if(color != null){
            out = out.color(TextColor.color(color));
        }
        return out;
    }

    public void sendBarMessage(Player p){
        this.sendChat(p,Component.text()
                .content(StringUtils.center("-----",53))
                .build());
    }
}
