package com.optv.inventryverse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterProducts extends RecyclerView.Adapter<AdapterProducts.ViewHolder> {

    private final Context c;
    private final ArrayList<ModelProducts> modelProducts;

    public AdapterProducts(Context c, ArrayList<ModelProducts> modelProducts) {
        this.c = c;
        this.modelProducts = modelProducts;
    }

    @NonNull
    @Override
    public AdapterProducts.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_products, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProducts.ViewHolder holder, int position) {
        ModelProducts m = modelProducts.get(position);
        holder.imageProductP.setImageResource(m.getProd_img());
        holder.nameProductP.setText(m.getProd_name());
        holder.stocksProductP.setText(String.format("No. of Stocks: %s", m.getProd_stocks()));
    }

    @Override
    public int getItemCount() {
        return modelProducts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageProductP;
        private final TextView nameProductP;
        private final TextView stocksProductP;

        public ViewHolder(@NonNull View v) {
            super(v);
            imageProductP = v.findViewById(R.id.imageProductP);
            nameProductP = v.findViewById(R.id.nameProductP);
            stocksProductP = v.findViewById(R.id.stocksProductP);
        }
    }
}
