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

import com.example.ryan.riglettemp.models.ChatAdapter;
import com.example.ryan.riglettemp.models.Friend;
import com.example.ryan.riglettemp.models.RecentAdapter;
import com.example.ryan.riglettemp.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Button home;
    private Button friendsList;
    private Button addFriend;
    private Button settings;
    private Button logOut;
    private User Me;
    private ArrayList<Friend> friends;
    private boolean hasFriends = false;
    private ListView listView;
    private RecentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);

        //get user object from parcelable
        Intent i = getIntent();
        Bundle oldBundle = i.getBundleExtra("bundle");
        Me = oldBundle.getParcelable("User");
        i.setExtrasClassLoader(getClassLoader());

        home = (Button) findViewById(R.id.home);
        friendsList = (Button) findViewById(R.id.friendsList);
        addFriend = (Button) findViewById(R.id.addFriend);
        settings = (Button) findViewById(R.id.settings);
        logOut = (Button) findViewById(R.id.logOut);
        listView = (ListView) findViewById(R.id.list_recent);

        initFriends();

        /*
        if (Me.getFriendsSize() == 0) {
            Toast.makeText(HomeActivity.this, "You have not added any friends", Toast.LENGTH_SHORT).show();
        } else {

            friends = new ArrayList<Friend>();
            //remove friends with no conversations
            for(int j=0; j<Me.getFriends().size(); j++){
                if (Me.getFriend(j).getMessagesSize()>0)
                    friends.add(Me.getFriend(j));
            }
            if(friends.size()!=0) {
                hasFriends = true;
                RecentAdapter adapter = new RecentAdapter(this, friends);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(this);
            }
            else{
                Toast.makeText(HomeActivity.this, "You have no conversations to display", Toast.LENGTH_SHORT).show();
            }
        }
        */

        adapter = new RecentAdapter(this, friends);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    private void initFriends() {
        friends = new ArrayList<Friend>(); // use to initialize existing coupons
        // for now its unused, its only being use to
        // instantiate ComplainArrayAdapter
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users")
                .child(Me.getFirebaseId()).child("friends");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final ArrayList<String> friendsID = new ArrayList<>();

                //retrieve user complaints ID
                for(DataSnapshot dataSP : dataSnapshot.getChildren())
                    friendsID.add(dataSP.getKey());

                //retrieve complains information
                for(final String friendID : friendsID) {
                    friends.clear();
                    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(friendID);
                    mDatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String fullname = dataSnapshot.child("fullname").getValue().toString();
                            String lastname = "";
                            boolean isMale = dataSnapshot.child("gender").getValue().toString().equals("m") ? true : false;
                            String id = dataSnapshot.child("id").getValue().toString();

                            adapter.add(new Friend(fullname, lastname, isMale, friendID));
                            Me.addFriend(fullname, lastname, isMale, friendID);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }


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
