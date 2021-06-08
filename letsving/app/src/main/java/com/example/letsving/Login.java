package com.example.letsving;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class Login extends AppCompatActivity {

    Button btnLogin;
    TextView tvEmailError;
    EditText etEmail, ePassword;
    String emailPattern;

    @Override                                                                                                                   
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        etEmail = findViewById(R.id.et_email);
        ePassword = findViewById(R.id.et_password);
        tvEmailError = findViewById(R.id.emailerror);
        //validate();
        emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
                if (etEmail.getText().toString().isEmpty()) {
                    //  tvEmailError.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Enter email address", Toast.LENGTH_SHORT).show();
                } else {
                    if (etEmail.getText().toString().trim().matches(emailPattern)) {
                        Intent intent = new Intent(Login.this, TabActivity.class);
                        startActivity(intent);
                        //  Toast.makeText(getApplicationContext(), "Valid email address", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void registerUser() {
        final String email = etEmail.getText().toString().trim();
        String password = ePassword.getText().toString().trim();

        //uset cannot go any further without entering password
        if (TextUtils.isEmpty(email)) {
            //email is empty
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            //stopping execution further
            return;
        }
        if (TextUtils.isEmpty(password)) {
            //password is empty
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            //stopping execution further
            return;
        }

    }
}