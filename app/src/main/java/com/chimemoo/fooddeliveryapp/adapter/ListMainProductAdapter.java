package com.chimemoo.fooddeliveryapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chimemoo.fooddeliveryapp.R;
import com.chimemoo.fooddeliveryapp.model.ProductModel;

import java.util.ArrayList;

public class ListMainProductAdapter extends RecyclerView.Adapter<ListMainProductAdapter.ListViewHolder> {
    private ArrayList<ProductModel> listProduct;

    public ListMainProductAdapter(ArrayList<ProductModel> list) {
        this.listProduct = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_col_product, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ProductModel product = listProduct.get(position);

        Glide.with(holder.itemView.getContext())
                .load(product.getImage())
                .into(holder.imgPhoto);

        holder.tvProductName.setText(product.getName());
        holder.tvProductPrice.setText(product.getPrice());
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvProductName, tvProductPrice;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_product);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);

        }
    }
}
