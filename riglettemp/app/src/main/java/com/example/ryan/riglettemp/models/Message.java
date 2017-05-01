package com.example.ryan.riglettemp.models;

/**
 * Created by ThinkPad-OwnerX220 on 4/29/2017.
 */

public class Message {
    private boolean isMe;       //flags receive / send
    private String message;     //actual text message
    private int userId;        //unique user ID

    public Message(String message, boolean isMe, int userId) {
        this.message = message;
        this.isMe = isMe;
        this.userId = userId;
    }

    public boolean getIsme() {
        return isMe;
    }

    public String getMessage() {
        return message;
    }

    public int getUserId() {
        return userId;
    }

    /*
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setMe(boolean isMe) {
        this.isMe = isMe;
    }
    */
}
