package net.mov51.periderm.chat;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class ChatPrefix {

    TextComponent componentPrefix;
    String basicPrefix;

    public ChatPrefix(String prefix){
        basicPrefix = prefix;
        componentPrefix = LegacyComponentSerializer.legacyAmpersand().deserialize(prefix);
    }

    public TextComponent getComponent(){
        return componentPrefix;
    }

    public String getBasic(){
        return basicPrefix;
    }

}
