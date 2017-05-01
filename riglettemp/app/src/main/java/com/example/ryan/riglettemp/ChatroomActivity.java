package com.example.ryan.riglettemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ryan.riglettemp.models.ChatAdapter;
import com.example.ryan.riglettemp.models.Message;

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
    boolean isMe = true;
    private List<Message> Messages;
    private ArrayAdapter<Message> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_activity);

        Messages = new ArrayList<>();

        /*
        //XML items
        home = (Button) findViewById(R.id.home);
        //friendsList = (Button) findViewById(R.id.friendsList);
        //addFriend = (Button) findViewById(R.id.addFriend);
        //settings = (Button) findViewById(R.id.settings);
        //logOut = (Button) findViewById(R.id.logOut);
        */

        listView = (ListView) findViewById(R.id.list_msg);
        btnSend = findViewById(R.id.btn_chat_send);
        messageInput = (EditText) findViewById(R.id.msg_type);

        //listview adapter
        adapter = new ChatAdapter(this, R.layout.chatbubble_right, Messages);
        listView.setAdapter(adapter);

        //1. need to populate messages here after receiving user ID

        //send event
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (messageInput.getText().toString().trim().equals("")) {
                    Toast.makeText(ChatroomActivity.this, "Please input some text...", Toast.LENGTH_SHORT).show();
                } else {
                    //add message to list
                    Message Message = new Message(messageInput.getText().toString(), isMe);
                    Messages.add(Message);
                    adapter.notifyDataSetChanged();
                    messageInput.setText("");
                    if (isMe) {     //toggle isMe for testing
                        isMe = false;
                    } else {
                        isMe = true;
                    }
                }
            }
        });


    }
}
