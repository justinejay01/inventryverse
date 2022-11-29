package com.optv.inventryverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Products extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products);

        RecyclerView rv = findViewById(R.id.rvProducts);

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

    }
}