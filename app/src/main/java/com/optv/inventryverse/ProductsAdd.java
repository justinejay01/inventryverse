package com.optv.inventryverse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class ProductsAdd extends AppCompatActivity {

    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_products);

        db = new DBHelper(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextInputEditText bcode = findViewById(R.id.barcProductA);
        TextInputEditText name = findViewById(R.id.nameProductA);
        TextInputEditText desc = findViewById(R.id.descProductA);
        TextInputEditText note = findViewById(R.id.noteProductA);

        Button addProd = (Button) findViewById(R.id.addProductA);
        addProd.setOnClickListener(view -> {
            int id = Integer.parseInt(bcode.getText().toString());
            boolean add = db.prodAdd(id, name.getText().toString(), desc.getText().toString(), note.getText().toString());
            if (add) {
                Toast.makeText(this, "Added!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, Products.class));
            } else {
                Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i = new Intent(this, Products.class);
        startActivity(i);
        return true;
    }
}