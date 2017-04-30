package com.example.ryan.riglettemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ChatroomActivity extends AppCompatActivity {
    private Button home;
    private Button friendsList;
    private Button addFriend;
    private Button settings;
    private Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_activity);

        home = (Button) findViewById(R.id.home);
        friendsList = (Button) findViewById(R.id.friendsList);
        addFriend = (Button) findViewById(R.id.addFriend);
        settings = (Button) findViewById(R.id.settings);
        logOut = (Button) findViewById(R.id.logOut);
    }
}
