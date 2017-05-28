package com.example.ryan.riglettemp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ryan.riglettemp.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private Button register_button;
    private Button forgotpass_button;
    private Button login_button;
    private EditText enter_username;
    private EditText enter_password;
    private User Me;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);


        register_button = (Button) findViewById(R.id.register_button);
        forgotpass_button = (Button) findViewById(R.id.forgotpass_button);
        login_button = (Button) findViewById(R.id.login_button);
        enter_username = (EditText) findViewById(R.id.enter_username);
        enter_password = (EditText) findViewById(R.id.enter_password);
        mAuth = FirebaseAuth.getInstance();

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String TAG = "EmailPassword";
                String email = enter_username.getText().toString();
                String password = enter_password.getText().toString();

                // [START sign_in_with_email]
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(LoginActivity.this, "Authentication success.",
                                            Toast.LENGTH_SHORT).show();

                                    enter_username.setText("");
                                    enter_password.setText("");

                                    Me = new User("gerry", "patia", false, "gfpatia");
                                    Me.setFirebaseId(user.getUid());
                                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                                    i.setExtrasClassLoader(getClassLoader());
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable("User", Me);
                                    i.putExtra("bundle",bundle);
                                    startActivity(i);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                // [END sign_in_with_email]


                /*
                Me.addFriend("John", "Doe", true, "asdsdfg3345f");
                Me.addFriend("Steve", "Jobs", false, "asdhsfgerghsdfhsfg");
                Me.addFriend("John", "Cena", false, "ax3456g");
                Me.addFriend("Jn", "na", true, "agf3456g");
                Me.addFriend("fd", "asdf", true, "aafasgf36g");
                Me.addFriend("khj", "df", true, "aaf6g");


                Me.addMessage("aafasgf36g", "test", false);
                Me.addMessage("ax3456g", "test", true);
                Me.addMessage("asdhsfgerghsdfhsfg", "tehst", false);
                Me.addMessage("ax3456g", "test", true);
                Me.addMessage("aafasgf36g", "test", false);
                Me.addMessage("ax3456g", "test", false);
                Me.addMessage("aafasgf36g", "test", true);
                Me.addMessage("ax3456g", "test", false);
                */

                //Code for packing the 'User' object, and sending it to the next activity
                //      User block of code any time you need to send the 'User' to a new screen
                /*
                Me = new User("first", "last", false, "username");
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                i.setExtrasClassLoader(getClassLoader());
                Bundle bundle = new Bundle();
                bundle.putParcelable("User", Me);
                i.putExtra("bundle",bundle);
                startActivity(i); */
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
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
