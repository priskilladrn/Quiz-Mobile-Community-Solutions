package com.example.insorma_2440110356;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    Context _context;
    ArrayList<Product> _products;
    public static ClickListener onClickListener;

    public ProductAdapter(Context context, ArrayList<Product> products){
        _context = context;
        _products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(_context).inflate(R.layout.layout_product, parent, false);

        ProductViewHolder viewHolder = new ProductViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Integer productImage = _products.get(position).productImage;
        String productName = _products.get(position).productName;
        Double productRating = _products.get(position).productRating;
        String productPrice = _products.get(position).productPrice;

        holder.imgFurniture.setImageResource(productImage);
        holder.tvFurnitureName.setText(productName);
        holder.tvFurniturePrice.setText(productPrice);
        holder.tvFurnitureRating.setText(productRating.toString());
    }

    @Override
    public int getItemCount() {

        return _products.size();
    }

    public void setClickListener(ClickListener _onClickListener){
        onClickListener = _onClickListener;
    }
}