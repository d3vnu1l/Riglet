package com.example.ryan.riglettemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ryan.riglettemp.models.User;

public class LoginActivity extends AppCompatActivity {
    private Button register_button;
    private Button forgotpass_button;
    private Button login_button;
    private EditText enter_username;
    private EditText enter_password;
    private User Me;


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
                Me.addFriend("John", "Doe", false, "asdf");
                Me.addMessage("asdf", "help", false);
                //Code for packing the 'User' object, and sending it to the next activity
                //      User block of code any time you need to send the 'User' to a new screen
                Intent i = new Intent(getApplicationContext(), ChatroomActivity.class);
                i.setExtrasClassLoader(getClassLoader());
                Bundle bundle = new Bundle();
                bundle.putParcelable("User", Me);
                i.putExtra("bundle",bundle);
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
