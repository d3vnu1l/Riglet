package com.example.ryan.riglettemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {
    private Button signUP_button;
    private EditText enter_fn;
    private EditText enter_ln;
    private EditText enter_id;
    private EditText enter_DOB;
    private EditText enter_pass;
    private EditText reEnter_pass;df
    private EditText enter_gender;
    private TextView screenHeader;
    private TextView fNDisplay;
    private TextView lNDisplay;
    private TextView idDisplay;
    private TextView dOBDisplay;
    private TextView passDisplay;
    private TextView reEnterPassDisplay;
    private TextView genderDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
}
