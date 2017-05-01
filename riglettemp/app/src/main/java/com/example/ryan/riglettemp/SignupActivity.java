package com.example.ryan.riglettemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    private EditText enter_fn;
    private EditText enter_ln;
    private EditText enter_DOB;
    private EditText enter_pass;
    private EditText reEnter_pass;
    private EditText enter_gender;
    private Button signUP_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUP_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String username = enter_username.getText().toString();
                //String password = enter_password.getText().toString();
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                //i.putExtra("username", username);
                startActivity(i);
            }
        });
    }
}
