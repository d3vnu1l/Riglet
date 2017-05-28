package com.example.ryan.riglettemp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ryan.riglettemp.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddFriendsActivity extends AppCompatActivity {
    private Button home;
    private Button friendsList;
    private Button addFriend;
    private Button settings;
    private Button logOut;
    private EditText en_uID;

    private Button AddFriendDiscard;
    private Button AddFriendAddFriend;

    private DatabaseReference mDatabase;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    private User Me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friends);

        Intent i = getIntent();
        Bundle oldBundle = i.getBundleExtra("bundle");
        Me = oldBundle.getParcelable("User");
        i.setExtrasClassLoader(getClassLoader());

        home = (Button) findViewById(R.id.home);
        friendsList = (Button) findViewById(R.id.friendsList);
        addFriend = (Button) findViewById(R.id.addFriend);
        settings = (Button) findViewById(R.id.settings);
        logOut = (Button) findViewById(R.id.logOut);

        AddFriendAddFriend = (Button) findViewById(R.id.AddFriendAddFriend);
        AddFriendDiscard = (Button) findViewById(R.id.AddFriendDiscard);

        en_uID = (EditText) findViewById(R.id.AddFriendUniqueID);


        AddFriendAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = "Place", lastName = "Holder";
                boolean gen = false;
                final String newFriendsID = en_uID.getText().toString().trim();
                //Verify uID and get other fields here from firebase

                if (newFriendsID.equals("")) {
                    Toast.makeText(AddFriendsActivity.this, "Enter a unique ID", Toast.LENGTH_SHORT).show();
                } else {
                    mDatabase = FirebaseDatabase.getInstance().getReference();

                    mDatabase.child("usersemailsid").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.hasChild(newFriendsID)) {
                                mDatabase.child("users").child(Me.getFirebaseId()).child("friends")
                                        .child(dataSnapshot.child(newFriendsID).getValue().toString()).setValue(true);
                                mDatabase.child("users").child((String) dataSnapshot.child(newFriendsID).getValue())
                                        .child("friends").child(Me.getFirebaseId()).setValue(true);
                                //Me.addFriend(firstName, lastName, gen, newFriendsID);
                                Toast.makeText(AddFriendsActivity.this, "Friend Added", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(AddFriendsActivity.this, "ID not found!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }

                en_uID.setText("");
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

            }
        });

        AddFriendDiscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                en_uID.setText("");
                Toast.makeText(AddFriendsActivity.this, "Changes Discarded", Toast.LENGTH_SHORT).show();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                i.setExtrasClassLoader(getClassLoader());
                Bundle bundle = new Bundle();
                bundle.putParcelable("User", Me);
                i.putExtra("bundle", bundle);
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
                i.putExtra("bundle", bundle);
                startActivity(i);
            }
        });
        addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do nothing
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
                i.setExtrasClassLoader(getClassLoader());
                Bundle bundle = new Bundle();
                bundle.putParcelable("User", Me);
                i.putExtra("bundle", bundle);
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
                i.putExtra("bundle", bundle);
                startActivity(i);
            }
        });
    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
