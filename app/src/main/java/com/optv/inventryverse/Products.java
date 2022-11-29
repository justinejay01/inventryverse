package com.optv.inventryverse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.optv.inventryverse.Admin.Dashboard;

import java.util.ArrayList;

public class Products extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView rv = findViewById(R.id.rvProducts);
        FloatingActionButton addProductP = (FloatingActionButton) findViewById(R.id.addProductP);

        ArrayList<ModelProducts> modelProducts = new ArrayList<ModelProducts>();
        modelProducts.add(new ModelProducts(R.drawable.ic_category_24, "Sample 1", 500));
        modelProducts.add(new ModelProducts(R.drawable.ic_category_24, "Sample 2", 500));
        modelProducts.add(new ModelProducts(R.drawable.ic_category_24, "Sample 3", 500));
        modelProducts.add(new ModelProducts(R.drawable.ic_category_24, "Sample 4", 500));
        modelProducts.add(new ModelProducts(R.drawable.ic_category_24, "Sample 5", 500));
        modelProducts.add(new ModelProducts(R.drawable.ic_category_24, "Sample 1", 500));
        modelProducts.add(new ModelProducts(R.drawable.ic_category_24, "Sample 2", 500));
        modelProducts.add(new ModelProducts(R.drawable.ic_category_24, "Sample 3", 500));
        modelProducts.add(new ModelProducts(R.drawable.ic_category_24, "Sample 4", 500));
        modelProducts.add(new ModelProducts(R.drawable.ic_category_24, "Sample 5", 500));

        AdapterProducts adapterProducts = new AdapterProducts(this, modelProducts);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapterProducts);

        addProductP.setOnClickListener(view -> {
            Intent i = new Intent(this, AddProducts.class);
            startActivity(i);
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i = new Intent(this, Dashboard.class);
        startActivity(i);
        return true;
    }
}