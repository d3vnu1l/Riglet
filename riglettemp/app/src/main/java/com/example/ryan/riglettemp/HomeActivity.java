package com.example.ryan.riglettemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    //Faux Tab Bar
    private Button home;
    private Button friendsList;
    private Button addFriend;
    private Button settings;
    private Button logOut;
    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);
    }
}
