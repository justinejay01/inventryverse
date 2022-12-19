package com.optv.inventryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ProductView extends AppCompatActivity {

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_view);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent i = getIntent();
        int id = i.getIntExtra("id", 1);

        db = new DBHelper(this);

        TextView barc = findViewById(R.id.txtPVBarc);
        TextView name = findViewById(R.id.txtPVName);
        TextView desc = findViewById(R.id.txtPVDesc);
        TextView note = findViewById(R.id.txtPVNote);

        Cursor c = db.prodGetData(id);
        if (c.getCount() > 0) {
            while (c.moveToNext()) {
                barc.setText(c.getString(0));
                name.setText(c.getString(1));
                desc.setText(c.getString(2));
                note.setText(c.getString(3));
            }
        } else {
            Toast.makeText(getApplicationContext(), "Nothing to show!", Toast.LENGTH_SHORT).show();
        }

    }
}