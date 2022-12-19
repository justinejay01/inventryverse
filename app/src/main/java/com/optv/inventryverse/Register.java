package com.optv.inventryverse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class Register extends AppCompatActivity {

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        db = new DBHelper(this);

        TextInputEditText fname = findViewById(R.id.regName);
        TextInputEditText email = findViewById(R.id.regEmail);
        TextInputEditText uname = findViewById(R.id.regUsername);
        TextInputEditText pass = findViewById(R.id.regPassword);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button reg = findViewById(R.id.regReg);
        reg.setOnClickListener(view -> {
            String n = fname.getText().toString();
            String e = email.getText().toString();
            String u = uname.getText().toString();
            String p = pass.getText().toString();

            String h_p = Hashing.sha256().hashString(p, StandardCharsets.UTF_8).toString();

            boolean register = db.accReg(n, e, u, h_p);
            if (register) {
                new AlertDialog.Builder(this)
                        .setTitle("Success")
                        .setMessage("Your registration will check and needs approval by the admin to review you. You can inform the admin to quickly approve your registration. Thank you!")
                        .setPositiveButton("OK", (dialogInterface, i) -> {
                            startActivity(new Intent(this, Start.class));
                        })
                        .setCancelable(false)
                        .show();
            } else {
                new AlertDialog.Builder(this)
                        .setTitle("Error")
                        .setMessage("There's a problem occur at the moment. Please try again or inform admin about the issue.")
                        .setPositiveButton("OK", null)
                        .setCancelable(false)
                        .show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i = new Intent(this, Start.class);
        startActivity(i);
        return true;
    }
}