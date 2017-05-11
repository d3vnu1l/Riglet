package com.example.ryan.riglettemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ryan.riglettemp.models.Friend;
import com.example.ryan.riglettemp.models.FriendAdapter;
import com.example.ryan.riglettemp.models.User;

import java.util.ArrayList;

public class FriendsListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Button home;
    private Button friendsList;
    private Button addFriend;
    private Button settings;
    private Button logOut;
    private User Me;
    private ArrayList<Friend> friends;
    private boolean hasFriends = false;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        //get user object from parcelable
        Intent i = getIntent();
        Bundle oldBundle = i.getBundleExtra("bundle");
        Me = oldBundle.getParcelable("User");
        i.setExtrasClassLoader(getClassLoader());


        home = (Button) findViewById(R.id.Home);
        friendsList = (Button) findViewById(R.id.FriendsList);
        addFriend = (Button) findViewById(R.id.AddFriend);
        settings = (Button) findViewById(R.id.Settings);
        logOut = (Button) findViewById(R.id.LogOut);

        listView = (ListView) findViewById(R.id.friendListView);

        if (Me.getFriendsSize() == 0) {
            Toast.makeText(FriendsListActivity.this, "You have not added any friends", Toast.LENGTH_SHORT).show();
        } else {
            //friends = Me.getFriends();
            hasFriends = true;
            FriendAdapter adapter = new FriendAdapter(this, Me.getFriends());
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }


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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String uID = Me.getFriends().get(position).getUID();
        Intent i = new Intent(getApplicationContext(), ChatroomActivity.class);
        i.setExtrasClassLoader(getClassLoader());
        Bundle bundle = new Bundle();
        bundle.putParcelable("User", Me);
        i.putExtra("bundle",bundle);
        i.putExtra("uID", uID);
        startActivity(i);

    }
}
