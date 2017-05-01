package com.example.ryan.riglettemp.models;

import java.util.List;

/**
 * Created by ryan on 4/30/2017.
 */

public class Friend{
    private String firstName;
    private String lastName;
    private boolean gender;
    private List<Message> Messages;

    public Friend(String firstName, String lastName, boolean gender, List<Message> Messages){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.Messages = Messages;
    }

    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName;}
    public boolean getGender(){ return gender;}
    public List<Message> getMessages(){ return Messages;}
}
