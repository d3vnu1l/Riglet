package com.example.ryan.riglettemp.models;

/**
 * Created by ThinkPad-OwnerX220 on 4/29/2017.
 */

public class Message {
    private boolean isMe;       //flags receive / send
    private String message;     //actual text message
    private Long userId;        //unique user ID
    private String dateTime;    //date / time of message

    public boolean getIsme() {
        return isMe;
    }
    public void setMe(boolean isMe) {
        this.isMe = isMe;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getDate() {
        return dateTime;
    }
    public void setDate(String dateTime) {
        this.dateTime = dateTime;
    }
}
