package com.example.ryan.riglettemp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by ThinkPad-OwnerX220 on 4/30/2017.
 */

public class User implements Parcelable{
    private String firstName;
    private String lastName;
    private boolean gender;
    private String uID;
    private ArrayList<Friend> Friends;
    private String email;

    ///*
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
        out.writeList(Friends);
        out.writeString(email);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    //constructor that takes a Parcel and gives you an object populated with it's values
    private User(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.gender = (boolean)in.readValue( null );
        this.uID = in.readString();
        this.Friends = new ArrayList<Friend>();
        in.readList(this.Friends, Friend.class.getClassLoader());
        this.email = in.readString();

    }
    //*/
    //CONSTRUCTORS
    public User(){
        this.firstName = new String();
        this.lastName = new String();
        this.gender = false;
        this.uID = "placeholderUID";
        this.email = "holder";
        this.Friends = new ArrayList<>();
    }
    public User(String firstName, String lastName, boolean gender, String uID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.uID = uID;
        this.Friends = new ArrayList<>();
        this.email = "holder";
    }

    //GET functions
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName;}
    public boolean getGender(){ return gender;}
    public ArrayList<Friend> getFriends(){ return Friends;}
        //GET functions (OVERLOADED for friends)
    public String getFirstName(String uID){
        return this.Friends.get(findFriendIndex(uID)).getFirstName();
    }
    public String getLastName(String uID){
        return this.Friends.get(findFriendIndex(uID)).getLastName();
    }
    public boolean getGender(String uID){
        return this.Friends.get(findFriendIndex(uID)).getGender();
    }
    public String getDisplayName(String uID){
        return this.Friends.get(findFriendIndex(uID)).getDisplayName();
    }
    public ArrayList<Message> getMessages(String uID){
        return (this.Friends.get(findFriendIndex(uID))).getMessages();
    }
    public String getRoomKey(String uID){
        return this.Friends.get(findFriendIndex(uID)).getRoomkey();
    }
    public Friend getFriend(int index){
        return this.Friends.get(index);
    }

    //Edit functions
    public void editFirstName(String fn){ this.firstName = fn; }
    public void editLastName(String ln){ this.lastName = ln; }
    public void editGender(boolean gen){ this.gender = gen; }
        //Edit functions (OVERLOADED for friends)
    public void editFirstName(String uID, String fn){
        int index = findFriendIndex(uID);
        Friend Friend_temp = this.Friends.get(index);
        Friend_temp.editFirstName(fn);
        this.Friends.set(index, Friend_temp);
    }
    public void editLastName(String uID, String ln){
        int index = findFriendIndex(uID);
        Friend Friend_temp = this.Friends.get(index);
        Friend_temp.editLastName(ln);
        this.Friends.set(index, Friend_temp);
    }
    public void editGender(String uID, boolean gen){
        int index = findFriendIndex(uID);
        Friend Friend_temp = this.Friends.get(index);
        Friend_temp.editGender(gen);
        this.Friends.set(index, Friend_temp);
    }
    public void editDisplayName(String uID, String newname){
        int index = findFriendIndex(uID);
        Friend Friend_temp = this.Friends.get(index);
        Friend_temp.editDisplayName(newname);
        this.Friends.set(index, Friend_temp);
    }
    public void editRoomKey(String uID, String roomKey){
        int index = findFriendIndex(uID);
        Friend Friend_temp = this.Friends.get(index);
        Friend_temp.editRoomKey(roomKey);
        this.Friends.set(index, Friend_temp);
    }

    //Add/Remove functions
    public void removeFriend(String uID){
        int index = findFriendIndex(uID);
        this.Friends.remove(index);
    }
    public void addFriend(String firstName, String lastName, boolean gender, String uID){
        Friend Friend_temp = new Friend(firstName, lastName, gender, uID);
        this.Friends.add(Friend_temp);
    }
    public void addMessage(String uID, String message, boolean isMe){
        int index = findFriendIndex(uID);
        Message Message_temp = new Message(message, isMe);  //form message
        Friend Friend_temp = this.Friends.get(index);
        Friend_temp.addMessage(Message_temp);
        this.Friends.set(index, Friend_temp);
    }

    public int getMessagesSize(String uID){
        return this.Friends.get(findFriendIndex(uID)).getMessages().size();
    }

    public int getFriendsSize(){
        return this.Friends.size();
    }

    //Find function (INTERNAL use only)
    //note this is terribly inefficient, hashmap would be better
    private int findFriendIndex(String uID){
        for (int i = 0; i < this.Friends.size(); i++) {
            if ((this.Friends.get(i).getUID()).equals(uID)) {
                return i;
            }
        }
        return 0;
    }
}
