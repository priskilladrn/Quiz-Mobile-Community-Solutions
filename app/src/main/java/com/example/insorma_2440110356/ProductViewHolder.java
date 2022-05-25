package com.example.insorma_2440110356;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView imgFurniture;
    public TextView tvFurnitureName, tvFurniturePrice, tvFurnitureRating;


    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        imgFurniture = itemView.findViewById(R.id.imgFurniture);
        tvFurnitureName = itemView.findViewById(R.id.tvFurnitureName);
        tvFurniturePrice = itemView.findViewById(R.id.tvPrice);
        tvFurnitureRating = itemView.findViewById(R.id.tvRating);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (ProductAdapter.onClickListener != null) ProductAdapter.onClickListener.onClick(view, getAdapterPosition());
    }
}
