package com.example.ryan.riglettemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotpassActivity extends AppCompatActivity {
    private Button resetBut;
    private EditText emailET;
    private TextView promptTV;
    private TextView screenHeader;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass_activity);

        resetBut = (Button) findViewById(R.id.resetBut);
        emailET = (EditText) findViewById(R.id.emailET);
        promptTV = (TextView)findViewById(R.id.promptTV);
        screenHeader = (TextView)findViewById(R.id.screenHeader);
    }
}
