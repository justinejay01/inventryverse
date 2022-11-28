package com.optv.inventryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        Button login = (Button) findViewById(R.id.startLogin);
        Button reg = (Button) findViewById(R.id.startRegister);

        Intent i = new Intent();

        login.setOnClickListener(view -> {
            i.setClass(getApplicationContext(), Login.class);
            startActivity(i);
        });

        reg.setOnClickListener(view -> {
            i.setClass(getApplicationContext(), Register.class);
            startActivity(i);
        });
    }


}