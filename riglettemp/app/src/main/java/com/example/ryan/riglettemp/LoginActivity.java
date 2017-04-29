package com.example.ryan.riglettemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private Button register_button;
    private Button forgotpass_button;
    private Button login_button;
    private EditText enter_username;
    private EditText enter_password;
    //private ImageView imageDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        register_button = (Button) findViewById(R.id.register_button);
        forgotpass_button = (Button) findViewById(R.id.forgotpass_button);
        login_button = (Button) findViewById(R.id.login_button);

        enter_password = (EditText) findViewById(R.id.enter_password);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = enter_username.getText().toString();
                String password = enter_password.getText().toString();
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                //i.putExtra("username", username);
                startActivity(i);
            }
        });
        forgotpass_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ForgotpassActivity.class);
                startActivity(i);
            }
        });
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(i);
            }
        });
    }
}
