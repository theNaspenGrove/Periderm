package net.mov51.periderm.helperObjects;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;

public class ChatPrefix {

    TextComponent componentPrefix;
    String basicPrefix;

    public ChatPrefix(String prefix){
        basicPrefix = prefix;
        componentPrefix = Component.text("[")
                .color(NamedTextColor.GOLD)
                .decoration(TextDecoration.BOLD, true)
                .append(Component.text(prefix)
                        .color(NamedTextColor.DARK_GREEN)
                        .decoration(TextDecoration.BOLD, false))
                .append(Component.text("] ")
                        .color(NamedTextColor.GOLD)
                        .decoration(TextDecoration.BOLD, true));
    }

    public TextComponent getComponent(){
        return componentPrefix;
    }

    public String getBasic(){
        return basicPrefix;
    }

}
