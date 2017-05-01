package com.example.ryan.riglettemp.models;

import java.util.List;

/**
 * Created by ThinkPad-OwnerX220 on 4/30/2017.
 */

public class User{
    private String firstName;
    private String lastName;
    private boolean gender;
    private List<Friend> Friends;

    public User(String firstName, String lastName, boolean gender, List<Friend> Friends){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.Friends = Friends;
    }

    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName;}
    public boolean getGender(){ return gender;}
    public List<Friend> getFriends(){ return Friends;}

    public String getFirstName(Friend friend){ return friend.getFirstName(); }
    public String getLastName(Friend friend){ return friend.getLastName();}
    public boolean getGender(Friend friend){ return friend.getGender();}
    public List<Message> getMessages(Friend friend){ return friend.getMessages();}
}
