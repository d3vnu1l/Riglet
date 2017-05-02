package com.example.ryan.riglettemp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by ThinkPad-OwnerX220 on 4/29/2017.
 */

public class Message implements Parcelable{
    private boolean isMe;       //flags receive / send
    private String message;     //actual text message
    private String dateTime;

    // 99.9% of the time you can just ignore this
    @Override
    public int describeContents() {
        return 0;
    }

    // write your object's data to the passed-in Parcel
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeValue(isMe);
        out.writeString(message);
        out.writeString(dateTime);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    //constructor that takes a Parcel and gives you an object populated with it's values
    private Message(Parcel in) {
        this.isMe = (boolean)in.readValue( null );
        this.message = in.readString();
        this.dateTime = in.readString();
    }

    public Message(String message, boolean isMe) {
        this.message = message;
        this.isMe = isMe;
        this.dateTime = DateFormat.getDateTimeInstance().format(new Date());
    }

    public boolean getIsme() {
        return isMe;
    }

    public String getMessage() {
        return message;
    }

    public String getDateTime() { return dateTime; }
}
