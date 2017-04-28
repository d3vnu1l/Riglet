package com.example.ryan.riglettemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotpassActivity extends AppCompatActivity {
    private Button resetBut;
    private EditText emailET;
    private TextView proptTV;
    private TextView screenHeader;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass_activity);
    }
}
