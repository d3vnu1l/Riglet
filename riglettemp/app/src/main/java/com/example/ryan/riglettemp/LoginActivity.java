package com.example.ryan.riglettemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private Button signupBut;
    private Button passwordBut;
    private Button forgotidBut;
    private EditText nameET;
    private EditText passwordET;
    private TextView screenHeader;
    private TextView idTV;
    private TextView passwordTV;
    private ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);


        signupBut = (Button) findViewById(R.id.signupBut);
        passwordBut = (Button) findViewById(R.id.passwordBut);
        forgotidBut = (Button) findViewById(R.id.forgotidBut);

        nameET = (EditText) findViewById(R.id.nameET);
        passwordET = (EditText) findViewById(R.id.passwordET);

        screenHeader = (TextView)findViewById(R.id.screenHeader);
        idTV = (TextView)findViewById(R.id.idTV);
        passwordTV = (TextView)findViewById(R.id.passwordTV);

        screenHeader.setText("Log In");
        screenHeader.setText("Unique ID");
        screenHeader.setText("Password");

        signupBut.setOnClickListener(new View.OnClickListener() {
            /*
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("username", usename.getText().toString());
                startActivity(i);
            }
            */
        });
    }
}
