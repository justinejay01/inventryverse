package com.optv.inventryverse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextInputEditText uname = (TextInputEditText) findViewById(R.id.loginUsername);
        TextInputEditText pword = (TextInputEditText) findViewById(R.id.loginPassword);
        Button login = (Button) findViewById(R.id.loginLogin);

        Intent i = new Intent();
        login.setOnClickListener(view -> {
            if (String.valueOf(uname.getText()).equals("admin") && String.valueOf(pword.getText()).equals("admin")) {
                Toast.makeText(getApplicationContext(), "Successful!", Toast.LENGTH_LONG).show();
                i.setClass(getApplicationContext(), Dashboard.class);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "Invalid credentials!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i = new Intent(getApplicationContext(), Start.class);
        startActivity(i);
        return true;
    }
}