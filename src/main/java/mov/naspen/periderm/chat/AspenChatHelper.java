package mov.naspen.periderm.chat;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
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

    //Default - Underlined & Dark Aqua - overloaded with String
    public TextComponent buildRunCommandComponent(String message, String command){
        return buildRunCommandComponent(LegacyComponentSerializer.legacyAmpersand().deserialize(message),command,true);
    }

    //Default - Underlined & Dark Aqua
    public TextComponent buildRunCommandComponent(TextComponent message, String command){
        return buildRunCommandComponent(message,command,true);
    }

    //Underlined & custom color - overloaded with String
    public TextComponent buildRunCommandComponent(String message, String command, NamedTextColor color){
        return buildRunCommandComponent(LegacyComponentSerializer.legacyAmpersand().deserialize(message),command,true,color);
    }

    //Underlined & custom color
    public TextComponent buildRunCommandComponent(TextComponent message, String command, NamedTextColor color){
        return buildRunCommandComponent(message,command,true,color);
    }

    //Optionally underlined & Dark Aqua - overloaded with String
    public TextComponent buildRunCommandComponent(String message, String command, boolean underlined){
        return buildRunCommandComponent (LegacyComponentSerializer.legacyAmpersand().deserialize(message), command, underlined,NamedTextColor.DARK_AQUA);
    }

    //Optionally underlined & Dark Aqua
    public TextComponent buildRunCommandComponent(TextComponent message, String command, boolean underlined){
        return buildRunCommandComponent (message, command, underlined,NamedTextColor.DARK_AQUA);
    }

    public TextComponent buildRunCommandComponent(String message, String command, boolean underlined, NamedTextColor color){
        return buildRunCommandComponent(LegacyComponentSerializer.legacyAmpersand().deserialize(message),command,underlined,color);
    }

    //optionally underlined & custom color
    public TextComponent buildRunCommandComponent(TextComponent message, String command, boolean underlined, NamedTextColor color){

        TextComponent out = message
                .clickEvent(ClickEvent.runCommand(command))
                .decoration(TextDecoration.UNDERLINED,underlined);
        if(color != null){
            out = out.color(TextColor.color(color));
        }
        return out;
    }

    //Default - Underlined & Dark Aqua - overloaded with String
    public TextComponent buildSuggestCommandComponent(String message, String command){
        return buildSuggestCommandComponent(LegacyComponentSerializer.legacyAmpersand().deserialize(message),command,true);
    }

    //Default - Underlined & Dark Aqua
    public TextComponent buildSuggestCommandComponent(TextComponent message, String command){
        return buildSuggestCommandComponent(message,command,true);
    }

    //Underlined & custom color
    public TextComponent buildSuggestCommandComponent(TextComponent message, String command,NamedTextColor color){
        return buildSuggestCommandComponent(message,command,true,color);
    }

    //Optionally underlined & Dark Aqua - overloaded with String
    public TextComponent buildSuggestCommandComponent(String message, String command,boolean underlined){
        return buildSuggestCommandComponent(LegacyComponentSerializer.legacyAmpersand().deserialize(message),command,underlined,NamedTextColor.DARK_AQUA);
    }

    //Optionally underlined & Dark Aqua
    public TextComponent buildSuggestCommandComponent(TextComponent message, String command,boolean underlined){
        return buildSuggestCommandComponent(message,command,underlined,NamedTextColor.DARK_AQUA);
    }

    //optionally underlined & custom color
    public TextComponent buildSuggestCommandComponent(TextComponent message, String command,boolean underlined,NamedTextColor color){
        TextComponent out = message
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
