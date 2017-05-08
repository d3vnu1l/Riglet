package com.example.ryan.riglettemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ryan.riglettemp.models.Friend;
import com.example.ryan.riglettemp.models.User;

import java.util.ArrayList;
import java.util.List;

public class FriendsListActivity extends AppCompatActivity {
    private Button home;
    private Button friendsList;
    private Button addFriend;
    private Button settings;
    private Button logOut;
    private List Friends;
    private Friend friend;
    private User Me;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        Intent i = getIntent();
        Bundle oldBundle = i.getBundleExtra("bundle");
        Me = oldBundle.getParcelable("User");
        i.setExtrasClassLoader(getClassLoader());

        ArrayList<Friend> myFriendList = Me.getFriends();
        //ListView listview = (ListView) findViewById(R.id.FriendsListView);

        //for (int ij = 0; ij < this.Friends.size(); ij++) {
            //listview
        //}


        home = (Button) findViewById(R.id.Home);
        friendsList = (Button) findViewById(R.id.FriendsList);
        addFriend = (Button) findViewById(R.id.AddFriend);
        settings = (Button) findViewById(R.id.Settings);
        logOut = (Button) findViewById(R.id.LogOut);

        //Tab Bar
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
}
