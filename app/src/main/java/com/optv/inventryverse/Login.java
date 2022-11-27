package com.optv.inventryverse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        TextInputEditText uname = (TextInputEditText) findViewById(R.id.loginUsername);
        TextInputEditText pword = (TextInputEditText) findViewById(R.id.loginPassword);
        Button login = (Button) findViewById(R.id.loginLogin);

        login.setOnClickListener(view -> {
            AlertDialog.Builder b = new AlertDialog.Builder(getApplicationContext());
            b.setTitle("Account Credentials")
                    .setMessage("Username: " + uname.getText() + "\nPassword: " + pword.getText());
            AlertDialog d = b.create();
        });
    }
}