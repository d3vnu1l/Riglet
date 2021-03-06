package com.example.ryan.riglettemp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by ryan on 4/30/2017.
 */

public class Friend implements Parcelable{
    private String firstName;
    private String lastName;
    private boolean gender;
    private String uID;
    private String displayName;
    private ArrayList<Message> Messages;
    private String roomKey;

    // 99.9% of the time you can just ignore this
    @Override
    public int describeContents() {
        return 0;
    }

    // write your object's data to the passed-in Parcel
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(firstName);
        out.writeString(lastName);
        out.writeValue(gender);
        out.writeString(uID);
        out.writeString(displayName);
        out.writeList(Messages);
        out.writeString(roomKey);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Friend> CREATOR = new Parcelable.Creator<Friend>() {
        public Friend createFromParcel(Parcel in) {
            return new Friend(in);
        }

        public Friend[] newArray(int size) {
            return new Friend[size];
        }
    };

    //constructor that takes a Parcel and gives you an object populated with it's values
    private Friend(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.gender = (boolean)in.readValue( null );
        this.uID = in.readString();
        this.displayName=in.readString();
        this.Messages = new ArrayList<Message>();
        in.readList(this.Messages, Message.class.getClassLoader());
        this.roomKey = in.readString();
    }

    //CONSTRUCTORS
    public Friend(){
        this.firstName = "";
        this.lastName = "";
        this.gender = false;
        this.uID = "placeholderUID";
        this.displayName = "";
        this.Messages = new ArrayList<>();
        this.roomKey = "";
    }

    public Friend(String firstName, String lastName, boolean gender, String uID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.uID = uID;
        this.displayName = firstName + " " + lastName;
        this.Messages = new ArrayList<>();
        this.roomKey = "";
    }

    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName;}
    public boolean getGender(){ return gender;}
    public String getUID() { return uID; }
    public String getDisplayName(){ return this.displayName; }
    public ArrayList<Message> getMessages(){ return Messages;}
    public int getMessagesSize(){
        return Messages.size();
    }
    public String getRoomkey(){
        return this.roomKey;
    }


    public void editFirstName(String fn){ this.firstName = fn; }
    public void editLastName(String ln){ this.firstName = ln; }
    public void editGender(boolean gen){ this.gender = gen; }
    public void editDisplayName(String newname){
        this.displayName=newname;
    }
    public void editRoomKey(String roomKey){
        this.roomKey = roomKey;
    }

    public void addMessage(Message Message_temp){ this.Messages.add(Message_temp); }
}
