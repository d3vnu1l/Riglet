package com.example.ryan.riglettemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ryan.riglettemp.models.User;

public class SettingsActivity extends AppCompatActivity {
    private Button home;
    private Button friendsList;
    private Button addFriend;
    private Button settings;
    private Button logOut;

    private Button SettingsDiscardChanges;
    private Button SettingsSaveChanges;
    private EditText SettingsFirstName;
    private EditText SettingsLastName;
    private EditText SettingsPassword;
    private EditText SettingsGender;

    private User Me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //get user object from parcelable
        Intent i = getIntent();
        Bundle oldBundle = i.getBundleExtra("bundle");
        Me = oldBundle.getParcelable("User");
        i.setExtrasClassLoader(getClassLoader());

        //XML items
        home = (Button) findViewById(R.id.Home);
        friendsList = (Button) findViewById(R.id.FrindsList);
        addFriend = (Button) findViewById(R.id.AddFriend);
        settings = (Button) findViewById(R.id.Settings);
        logOut = (Button) findViewById(R.id.LogOut);

        //*
        SettingsFirstName = (EditText) findViewById(R.id.SettingsFirstName);
        SettingsLastName = (EditText) findViewById(R.id.SettingsLastName);
        SettingsPassword = (EditText) findViewById(R.id.SettingsPassword);
        SettingsGender = (EditText) findViewById(R.id.SettingsGender);
        SettingsSaveChanges = (Button) findViewById(R.id.SettingsSaveChanges);
        SettingsDiscardChanges = (Button) findViewById(R.id.SettingsDiscardChanges);

        SettingsSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FirstName = SettingsFirstName.getText().toString().trim();
                String LastName = SettingsLastName.getText().toString().trim();
                String Password = SettingsPassword.getText().toString().trim();
                String Gender = SettingsGender.getText().toString().trim();

                //check for all fields entry
                if (FirstName.equals("") || LastName.equals("") || Password.equals("") || Gender.equals(""))
                {
                    Toast.makeText(SettingsActivity.this, "Please complete all fields.", Toast.LENGTH_SHORT).show();
                }
                //need to check that uid is unique here
                else
                {
                    if (Gender.toLowerCase().equals("m") || Gender.toLowerCase().equals("male")) {
                        Me.editFirstName(FirstName);
                        Me.editLastName(LastName);
                        //Me.editPassword(Password);
                        Me.editGender(true);
                        Toast.makeText(SettingsActivity.this, "Settings saved", Toast.LENGTH_SHORT).show();
                    }
                    else if(Gender.toLowerCase().equals("f") || Gender.toLowerCase().equals("female")){
                        Me.editFirstName(FirstName);
                        Me.editLastName(LastName);
                        //Me.editPassword(Password);
                        Me.editGender(false);
                        Toast.makeText(SettingsActivity.this, "Settings saved", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(SettingsActivity.this, "Invalid gender", Toast.LENGTH_SHORT).show();
                }
            }
        });
        SettingsDiscardChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsFirstName.setText("");
                SettingsLastName.setText("");
                SettingsPassword.setText("");
                SettingsGender.setText("");
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
            //do nothing
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
