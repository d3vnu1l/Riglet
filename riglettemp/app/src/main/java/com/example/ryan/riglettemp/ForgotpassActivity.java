package com.example.ryan.riglettemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotpassActivity extends AppCompatActivity {
    //private Button resetBut;
    private EditText enter_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass_activity);

        enter_email = (EditText) findViewById(R.id.enter_email);

        //NEED SEND EMAIL FUNCTION HERE
    }
}
