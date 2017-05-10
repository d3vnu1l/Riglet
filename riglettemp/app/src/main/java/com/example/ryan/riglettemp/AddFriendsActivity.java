package com.example.ryan.riglettemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ryan.riglettemp.models.User;

public class AddFriendsActivity extends AppCompatActivity {
    private Button home;
    private Button friendsList;
    private Button addFriend;
    private Button settings;
    private Button logOut;
    private User Me;

    private Button AddFriendDiscard;
    private Button AddFriendAddFriend;
    private EditText AddFriendUniqueID;
    private EditText AddFriendFirstName;
    private EditText AddFriendLastName;
    private EditText AddFriendGender;


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
/*
        en_firstName = (EditText) findViewById(R.id.AddFriendFirstName);
        en_lastName = (EditText) findViewById(R.id.AddFreindLastName)
        en_gender = (EditText) findViewById(R.id.AddFriendGender)
        en_uID = (EditText) findViewById(R.id.AddFriendUniqueID)
*/


        AddFriendAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                String fistName = en_firstName.getText().toString().trim();
                String lastName = en_lastName.getText().toString().trim();
                String gender = en_gender.getText().toString().trim();
                String uID = en_uID.getText().toString().trim();

                if (gen.toLowerCase().equals("m") || gen.toLowerCase().equals("male")) {
                    Me.addFriend(fn, ln, true, uID);
                    Toast.makeText(AddFriendsActivity.this, "Friend Added!", Toast.LENGTH_SHORT).show();
                }
                else if (gen.toLowerCase().equals("f") || gen.toLowerCase().equals("female")) {
                    Me.addFriend(fn, ln, false, uID);
                    Toast.makeText(AddFriendsActivity.this, "Friend Added!", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(AddFriendsActivity.this, "Invalid gender", Toast.LENGTH_SHORT).show();
                */
            }
        });

        AddFriendDiscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddFriendFirstName.setText("");
                AddFriendLastName.setText("");
                AddFriendGender.setText("");
                AddFriendUniqueID.setText("");
            }
        });

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
