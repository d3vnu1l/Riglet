package com.example.ryan.riglettemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ryan.riglettemp.models.User;

public class SignupActivity extends AppCompatActivity {
    private EditText enter_fn;
    private EditText enter_ln;
    private EditText enter_pass;
    private EditText reEnter_pass;
    private EditText enter_gender;
    private EditText enter_id;
    private Button signUP_button;

    private User Me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        enter_fn = (EditText) findViewById(R.id.enter_fn);
        enter_ln = (EditText) findViewById(R.id.enter_ln);
        enter_pass = (EditText) findViewById(R.id.enter_pass);
        reEnter_pass = (EditText) findViewById(R.id.reEnter_pass);
        enter_gender = (EditText) findViewById(R.id.enter_gender);
        enter_id = (EditText) findViewById(R.id.enter_id);
        signUP_button = (Button) findViewById(R.id.signUP_button);

        signUP_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fn = enter_fn.getText().toString().trim();
                String ln = enter_ln.getText().toString().trim();
                String pass = enter_pass.getText().toString().trim();
                String repass = reEnter_pass.getText().toString().trim();
                String uID = enter_id.getText().toString().trim();
                String gen = enter_gender.getText().toString().trim();

                //check for all fields entry
                if (fn.equals("") || ln.equals("") || pass.equals("") || repass.equals("") || gen.equals("") || uID.equals("")) {
                    Toast.makeText(SignupActivity.this, "Please complete all fields.", Toast.LENGTH_SHORT).show();
                }
                //need to check that uid is unique here
                else if (pass.equals(repass)){
                    if (gen.toLowerCase().equals("m") || gen.toLowerCase().equals("male")) {
                        Me = new User(fn, ln, true, uID);

                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        i.setExtrasClassLoader(getClassLoader());
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("User", Me);
                        i.putExtra("bundle",bundle);
                        startActivity(i);
                    }
                    else if(gen.toLowerCase().equals("f") || gen.toLowerCase().equals("female")) {
                        Me = new User(fn, ln, false, uID);
                        
                        Intent i = new Intent(getApplicationContext(), ChatroomActivity.class);
                        i.setExtrasClassLoader(getClassLoader());
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("User", Me);
                        i.putExtra("bundle",bundle);
                        startActivity(i);
                    }
                    else
                        Toast.makeText(SignupActivity.this, "Invalid gender", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
