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
                //String username = enter_username.getText().toString();
                //String password = enter_password.getText().toString();

                //1. Create new User using info
                Me = new User("JON", "doe", false, 1111);
                //2. Add users friends
                Me.addFriend("Ryan", "Deushane", true, 1234);
                //3. Add users messages
                Me.addMessage(1234, "test", false);
                Me.addMessage(1234, "testing", true);
                Me.addMessage(1234, "test", true);
                Me.addMessage(1234, "testing", true);
                Me.addMessage(1234, "test", true);
                Me.addMessage(1234, "testing", true);
                Me.addMessage(1234, "test", true);
                Me.addMessage(1234, "testing", true);
                Me.addMessage(1234, "test", true);
                Me.addMessage(1234, "test", false);
                Me.addMessage(1234, "testing", true);
                Me.addMessage(1234, "test", true);
                Me.addMessage(1234, "testing", true);
                Me.addMessage(1234, "test", true);
                Me.addMessage(1234, "testing", true);
                Me.addMessage(1234, "test", true);
                Me.addMessage(1234, "testing", true);
                Me.addMessage(1234, "test", true);
                Me.addMessage(1234, "test", false);
                Me.addMessage(1234, "testing", true);
                Me.addMessage(1234, "test", true);
                Me.addMessage(1234, "testing", true);
                Me.addMessage(1234, "test", true);
                Me.addMessage(1234, "testing", true);
                Me.addMessage(1234, "test", true);
                Me.addMessage(1234, "testing", true);
                Me.addMessage(1234, "test", true);

                Intent i = new Intent(getApplicationContext(), ChatroomActivity.class);
                i.setExtrasClassLoader(getClassLoader());
                Bundle bundle = new Bundle();
                bundle.putParcelable("User", Me);
                i.putExtra("bundle",bundle);
                //i.putExtra("User", Me);
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
