package com.example.ryan.riglettemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ryan.riglettemp.models.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditFriendsActivity extends AppCompatActivity {
    private Button home;
    private Button friendsList;
    private Button addFriend;
    private Button settings;
    private Button logOut;
    private User Me;

    private Button EditFriendSave;
    private Button EditFriendDelete;
    private EditText EditFriendDisplayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_friends);

        //get user object from parcelable
        Intent i = getIntent();
        Bundle oldBundle = i.getBundleExtra("bundle");
        Me = oldBundle.getParcelable("User");
        i.setExtrasClassLoader(getClassLoader());
        //retreive uID from intent
        final String friendID = getIntent().getExtras().getString("uID","defaultKey");

        EditFriendDisplayName = (EditText) findViewById(R.id.EditFriendDisplayName);
        EditFriendDisplayName.setText(Me.getDisplayName(friendID));

        home = (Button) findViewById(R.id.home);
        friendsList = (Button) findViewById(R.id.friendsList);
        addFriend = (Button) findViewById(R.id.addFriend);
        settings = (Button) findViewById(R.id.settings);
        logOut = (Button) findViewById(R.id.logOut);

        EditFriendSave = (Button) findViewById(R.id.EditFriendSave);
        EditFriendDelete = (Button) findViewById(R.id.EditFriendDelete);

        Log.d("rigletdebug", friendID);

        EditFriendSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newname = EditFriendDisplayName.getText().toString();
                if(newname.equals("")){
                    Toast.makeText(EditFriendsActivity.this, "Display name connot be empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Me.editDisplayName(friendID, EditFriendDisplayName.getText().toString());
                    Intent i = new Intent(getApplicationContext(), FriendsListActivity.class);
                    i.setExtrasClassLoader(getClassLoader());
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("User", Me);
                    i.putExtra("bundle",bundle);
                    startActivity(i);
                }

            }
        });

        EditFriendDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Me.removeFriend(friendID);
                finish();
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users")
                        .child(Me.getFirebaseId()).child("friends").child(friendID);
                mDatabase.removeValue();
                mDatabase = FirebaseDatabase.getInstance().getReference().child("users")
                        .child(friendID).child("friends").child(Me.getFirebaseId());
                mDatabase.removeValue();

                Intent i = new Intent(getApplicationContext(), FriendsListActivity.class);
                i.setExtrasClassLoader(getClassLoader());
                Bundle bundle = new Bundle();
                bundle.putParcelable("User", Me);
                i.putExtra("bundle",bundle);
                startActivity(i);

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
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
