package net.mov51.periderm.paper.chat;

import net.kyori.adventure.text.TextComponent;

public class PredefinedMessage {
    private final TextComponent message;

    public PredefinedMessage(TextComponent message){
        this.message = message;
    }

    public TextComponent getMessage() {
        return message;
    }
}
