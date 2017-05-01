package com.example.ryan.riglettemp.models;

/**
 * Created by ThinkPad-OwnerX220 on 4/29/2017.
 */

public class Message {
    private boolean isMe;       //flags receive / send
    private String message;     //actual text message

    public Message(String message, boolean isMe) {
        this.message = message;
        this.isMe = isMe;
    }

    public boolean getIsme() {
        return isMe;
    }

    public String getMessage() {
        return message;
    }
}
