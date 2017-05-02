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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_activity);

        //get user object from parcelable
        Intent i = getIntent();

        Bundle oldBundle = i.getBundleExtra("bundle");
        Me = oldBundle.getParcelable("User");
        i.setExtrasClassLoader(getClassLoader());



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
        adapter = new ChatAdapter(this, R.layout.chatbubble_right, Me.getMessages(1234));
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
                    Me.addMessage(1234, messageInput.getText().toString(), true);
                    adapter.notifyDataSetChanged();
                    messageInput.setText("");
                }
            }
        });


    }
}
