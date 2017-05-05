package com.example.ryan.riglettemp;

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
    private Button SettingSaveChanges;
    private EditText SettingsFirstName;
    private EditText SettingsLastName;
    private EditText SettingsPassword;
    private EditText SettingsGender;

    private User Me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        /*
        SettingsFirstName = (EditText) findViewById(R.id.SettingsFirstName);
        SettingsLastName = (EditText) findViewById(R.id.SettingsLastName);
        SettingsPassword = (EditText) findViewById(R.id.SettingsPassword);
        SettingsGender = (EditText) findViewById(R.id.SettingsGender);
        SettingSaveChanges = (Button) findViewById(R.id.SettingsSaveChanges);
        SettingsDiscardChanges = (Button) findViewById(R.id.SettingsDiscardChanges);
        //SettingsSaveChanges.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String FirstName = SettingsFirstName.getText().toString().trim();
                String LastName = SettingsLastName.getText().toString().trim();
                String Password = SettingsPassword.getText().toString().trim();
                String Gender = SettingsGender.getText().toString().trim();

                //String uID = getUserID().toString().trim(); //Need to implement getUserID command from backend

                //check for all fields entry
                if (FirstName.equals("") || LastName.equals("") || Password.equals("") || Gender.equals(""))
                {
                    Toast.makeText(SignupActivity.this, "Please complete all fields.", Toast.LENGTH_SHORT).show();
                }
                //need to check that uid is unique here
                else
                {
                    if (Gender.toLowerCase().equals("m") || Gender.toLowerCase().equals("male") || Gender.toLowerCase().equals("female") || Gender.toLowerCase().equals("f"))
                        Me = new User(FirstName, LastName, Gender, uID);
                    else
                        Toast.makeText(SignupActivity.this, "Invalid gender", Toast.LENGTH_SHORT).show();
                }
            }
        });

    /*
        SettingsDiscardChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsFirstName.setText("");
                SettingsLastName.setText("");
                SettingsPassword.setText("");
                SettingsGender.setText("");
            }
        });
*/
        /*
        //XML items
        home = (Button) findViewById(R.id.home);
        friendsList = (Button) findViewById(R.id.friendsList);
        addFriend = (Button) findViewById(R.id.addFriend);
        settings = (Button) findViewById(R.id.settings);
        logOut = (Button) findViewById(R.id.logOut);
        */



    }
}
