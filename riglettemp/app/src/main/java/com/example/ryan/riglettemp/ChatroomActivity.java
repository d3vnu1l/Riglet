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
import android.widget.TextView;
import android.widget.Toast;

import com.example.ryan.riglettemp.models.ChatAdapter;
import com.example.ryan.riglettemp.models.Message;
import com.example.ryan.riglettemp.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChatroomActivity extends AppCompatActivity {
    private Button home;
    private Button friendsList;
    private Button addFriend;
    private Button settings;
    private Button logOut;

    private TextView FriendName;

    private ListView listView;
    private View btnSend;
    private EditText messageInput;
    private List<Message> Messages;
    private ArrayAdapter<Message> adapter;
    private User Me;
    private boolean hasMessages = false;
    private String friendID;
    private String chatId;
    private DatabaseReference mDatabase;
    private int numOfMessage;
    private int messagePtr = 0;
    private String friendId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom_activity);

        //get user object from parcelable
        Intent i = getIntent();
        Bundle oldBundle = i.getBundleExtra("bundle");
        Me = oldBundle.getParcelable("User");
        i.setExtrasClassLoader(getClassLoader());
        friendID = getIntent().getExtras().getString("uID","defaultKey");

        //init chat database START
        if(Me.getFirebaseId().compareTo(friendID) > 0)
            chatId = friendID + Me.getFirebaseId();
        else
            chatId = Me.getFirebaseId() + friendID;

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("chatroom").hasChild(chatId)) {
                    initChat();
                } else {
                    adapter.clear();
                    mDatabase.child("chatroom").child(chatId).child("numOfMessage").setValue(0);
                }

                ValueEventListener numcomplainsListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get Post object and use the values to update the UI
                        numOfMessage = dataSnapshot.getValue(Integer.class);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Getting Post failed, log a message
                        Log.w("loadPost:onCancelled", databaseError.toException());
                    }
                };
                mDatabase.child("chatroom").child(chatId).child("numOfMessage")
                        .addValueEventListener(numcomplainsListener);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //init chat database END

        //XML items
        home = (Button) findViewById(R.id.Home);
        friendsList = (Button) findViewById(R.id.FrindsList);
        addFriend = (Button) findViewById(R.id.AddFriend);
        settings = (Button) findViewById(R.id.Settings);
        logOut = (Button) findViewById(R.id.LogOut);
        FriendName = (TextView) findViewById(R.id.FriendName);
        FriendName.setText(Me.getDisplayName(friendID));
        btnSend = findViewById(R.id.btn_chat_send);
        messageInput = (EditText) findViewById(R.id.msg_type);

        //chatadapter
        adapter = new ChatAdapter(this, Me.getMessages(friendID));
        listView = (ListView) findViewById(R.id.list_msg);

        //check if there are any messages to display
        //if (Me.getMessagesSize(friendID) == 0) {
        //    Toast.makeText(ChatroomActivity.this, "No messages to display", Toast.LENGTH_SHORT).show();
        //}
        //else {
        //    hasMessages = true;
            listView.setAdapter(adapter);
        //}

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
                    //add message to list at database
                    numOfMessage++;
                    mDatabase = FirebaseDatabase.getInstance().getReference().child("chatroom").child(chatId);
                    mDatabase.child("numOfMessage").setValue(numOfMessage);
                    mDatabase.child(String.valueOf(numOfMessage)).child("text").setValue(messageInput.getText().toString());
                    mDatabase.child(String.valueOf(numOfMessage)).child("sender").setValue(Me.getFirebaseId());

                    //add message to list locally
                    //gfMe.addMessage(friendID, messageInput.getText().toString(), true);
                    adapter.notifyDataSetChanged();
                    messageInput.setText("");
                }


            }
        });

        //tab bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                i.setExtrasClassLoader(getClassLoader());
                Bundle bundle = new Bundle();
                bundle.putParcelable("User", Me);
                i.putExtra("bundle",bundle);
                startActivity(i);
            }
        });
        friendsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), FriendsListActivity.class);
                i.setExtrasClassLoader(getClassLoader());
                Bundle bundle = new Bundle();
                bundle.putParcelable("User", Me);
                i.putExtra("bundle",bundle);
                startActivity(i);
            }
        });
        addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddFriendsActivity.class);
                i.setExtrasClassLoader(getClassLoader());
                Bundle bundle = new Bundle();
                bundle.putParcelable("User", Me);
                i.putExtra("bundle",bundle);
                startActivity(i);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
                i.setExtrasClassLoader(getClassLoader());
                Bundle bundle = new Bundle();
                bundle.putParcelable("User", Me);
                i.putExtra("bundle",bundle);
                startActivity(i);
            }
        });
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                i.setExtrasClassLoader(getClassLoader());
                Bundle bundle = new Bundle();
                bundle.putParcelable("User", Me);
                i.putExtra("bundle",bundle);
                startActivity(i);
            }
        });
    }

    private void initChat() {
        //clear chat
        adapter.clear();
        // instantiate ComplainArrayAdapter
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("chatroom").
                child(chatId);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final ArrayList<String> messageIDs = new ArrayList<>();

                //retrieve user complaints ID
                for(DataSnapshot dataSP : dataSnapshot.getChildren())
                    messageIDs.add(dataSP.getKey());

                //retrieve complains information
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().
                        child("chatroom").child(chatId);
                mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(int i=messagePtr; i<messageIDs.size()-1; i++) {
                            String text = (String) dataSnapshot.child(messageIDs.get(i)).child("text").getValue();
                            String senderId = (String) dataSnapshot.child(messageIDs.get(i)).child("sender").getValue();
                            String isMe = Me.getFirebaseId();
                            if (isMe.equals(senderId))
                                Me.addMessage(friendID, text, true);
                            else Me.addMessage(friendID, text, false);
                            messagePtr++;
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
