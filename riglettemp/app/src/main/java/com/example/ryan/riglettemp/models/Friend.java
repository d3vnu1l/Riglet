package com.example.ryan.riglettemp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ryan on 4/30/2017.
 */

public class Friend implements Parcelable{
    private String firstName;
    private String lastName;
    private boolean gender;
    private int uID;
    private ArrayList<Message> Messages;

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
        out.writeInt(uID);
        out.writeList(Messages);
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
        this.uID = in.readInt();
        this.Messages = new ArrayList<Message>();
        in.readList(this.Messages, Message.class.getClassLoader());
    }

    public Friend(){
        this.firstName = "";
        this.lastName = "";
        this.gender = false;
        this.uID = 0000;
        this.Messages = new ArrayList<>();
    }

    public Friend(String firstName, String lastName, boolean gender, int uID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.uID = uID;
        this.Messages = new ArrayList<>();
    }

    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName;}
    public boolean getGender(){ return gender;}
    public int getUID() { return uID; }
    public ArrayList<Message> getMessages(){ return Messages;}


    public void editFirstName(String fn){ this.firstName = fn; }
    public void editLastName(String ln){ this.firstName = ln; }
    public void editGender(boolean gen){ this.gender = gen; }

    public void addMessage(Message Message_temp){ this.Messages.add(Message_temp); }
}
