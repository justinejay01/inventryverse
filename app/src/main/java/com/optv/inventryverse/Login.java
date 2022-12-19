package com.optv.inventryverse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class Login extends AppCompatActivity {

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        db = new DBHelper(this);

        TextInputEditText uname = (TextInputEditText) findViewById(R.id.loginUsername);
        TextInputEditText pword = (TextInputEditText) findViewById(R.id.loginPassword);
        Button login = (Button) findViewById(R.id.loginLogin);

        login.setOnClickListener(view -> {
            String u = uname.getText().toString();
            String p = pword.getText().toString();

            String h_p = Hashing.sha256().hashString(p, StandardCharsets.UTF_8).toString();
            boolean loginb = db.accLogin(u, h_p);

            if (loginb) {
                Toast.makeText(this, "Successful!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, Dashboard.class));
            } else {
                new AlertDialog.Builder(this)
                        .setTitle("Error")
                        .setMessage("Invalid credentials or account doesn't exist!")
                        .setPositiveButton("OK", null)
                        .setCancelable(false)
                        .show();
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