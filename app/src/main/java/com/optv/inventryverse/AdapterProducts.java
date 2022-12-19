package com.optv.inventryverse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterProducts extends RecyclerView.Adapter<AdapterProducts.ViewHolder> {

    public interface setOnItemClickListener {
        void onItemClick(ModelProducts item);
    }

    private final Context c;
    private final ArrayList<ModelProducts> modelProducts;
    private final setOnItemClickListener onItemClickListener;

    public AdapterProducts(Context c, ArrayList<ModelProducts> modelProducts, setOnItemClickListener onItemClickListener) {
        this.c = c;
        this.modelProducts = modelProducts;
        this.onItemClickListener = onItemClickListener;
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
        holder.bind(modelProducts.get(position), onItemClickListener);
        holder.imageProductP.setImageResource(m.getProd_img());
        holder.nameProductP.setText(m.getProd_name());
        holder.stocksProductP.setText(String.format("No. of Stocks: %s", m.getProd_stocks()));
        holder.barcProductP.setText(String.valueOf(m.getProd_id()));
    }

    @Override
    public int getItemCount() {
        return modelProducts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageProductP;
        private final TextView nameProductP;
        private final TextView stocksProductP;
        private final TextView barcProductP;

        public ViewHolder(@NonNull View v) {
            super(v);
            imageProductP = v.findViewById(R.id.imageProductP);
            nameProductP = v.findViewById(R.id.nameProductP);
            stocksProductP = v.findViewById(R.id.stocksProductP);
            barcProductP = v.findViewById(R.id.barcProductP);
        }

        public void bind(final ModelProducts item, final setOnItemClickListener onItemClickListener) {
            itemView.setOnClickListener(view -> {
                onItemClickListener.onItemClick(item);
            });
        }
    }
}
