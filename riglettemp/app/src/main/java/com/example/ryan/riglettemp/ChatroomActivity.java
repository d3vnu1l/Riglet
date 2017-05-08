package com.example.ryan.riglettemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ryan.riglettemp.models.ChatAdapter;
import com.example.ryan.riglettemp.models.Message;
import com.example.ryan.riglettemp.models.User;

import java.util.ArrayList;
import java.util.List;

public class ChatroomActivity extends AppCompatActivity {
    private Button home;
    private Button friendsList;
    private Button addFriend;
    private Button settings;
    private Button logOut;

    private ListView listView;
    private View btnSend;
    private EditText messageInput;
    private List<Message> Messages;
    private ArrayAdapter<Message> adapter;
    private User Me;
    private boolean hasMessages = false;
    private String friendID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_activity);

        //get user object from parcelable
        Intent i = getIntent();
        Bundle oldBundle = i.getBundleExtra("bundle");
        Me = oldBundle.getParcelable("User");
        i.setExtrasClassLoader(getClassLoader());

        friendID = "asdf";

        /*
        //XML items
        home = (Button) findViewById(R.id.home);
        //friendsList = (Button) findViewById(R.id.friendsList);
        //addFriend = (Button) findViewById(R.id.addFriend);
        //settings = (Button) findViewById(R.id.settings);
        //logOut = (Button) findViewById(R.id.logOut);
        */

        btnSend = findViewById(R.id.btn_chat_send);
        messageInput = (EditText) findViewById(R.id.msg_type);

        //chatadapter
        adapter = new ChatAdapter(this, Me.getMessages(friendID));
        listView = (ListView) findViewById(R.id.list_msg);

        //check if there are any messages to display
        if (Me.getMessagesSize(friendID) == 0) {
            Toast.makeText(ChatroomActivity.this, "No messages to display", Toast.LENGTH_SHORT).show();
        }
        else {
            hasMessages = true;
            listView.setAdapter(adapter);
        }

        //send event
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hasMessages) {
                    hasMessages = true;
                    listView.setAdapter(adapter);   //sets up adapter after a messages is added
                }
                if (messageInput.getText().toString().trim().equals("")) {
                    Toast.makeText(ChatroomActivity.this, "Please input some text...", Toast.LENGTH_SHORT).show();
                } else {
                    //add message to list
                    Me.addMessage(friendID, messageInput.getText().toString(), true);
                    adapter.notifyDataSetChanged();
                    messageInput.setText("");
                }
            }
        });

    }
}
