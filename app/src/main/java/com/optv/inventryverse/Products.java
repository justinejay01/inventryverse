package com.optv.inventryverse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Products extends AppCompatActivity {

    DBHelper db;
    ArrayList<ModelProducts> modelProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        db = new DBHelper(this);

        RecyclerView rv = findViewById(R.id.rvProducts);
        FloatingActionButton addProductP = (FloatingActionButton) findViewById(R.id.addProductP);

        modelProducts = new ArrayList<ModelProducts>();
        getAllData();

        AdapterProducts adapterProducts = new AdapterProducts(this, modelProducts);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapterProducts);

        addProductP.setOnClickListener(view -> {
            Intent i = new Intent(this, AddProducts.class);
            startActivity(i);
        });
    }

    private void getAllData() {
        Cursor c = db.prodGetAll();
        if (c.getCount()>0){
            while (c.moveToNext()) {
                modelProducts.add(new ModelProducts(c.getInt(0), R.drawable.ic_category_24, c.getString(1), db.stocksGetCount(c.getString(1))));
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i = new Intent(this, Dashboard.class);
        startActivity(i);
        return true;
    }
}