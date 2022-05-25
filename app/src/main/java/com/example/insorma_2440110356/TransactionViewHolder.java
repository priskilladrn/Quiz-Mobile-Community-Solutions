package com.example.insorma_2440110356;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TransactionViewHolder extends RecyclerView.ViewHolder {
    TextView tvQuantityHistory, tvFurnitureNameHistory, tvId, tvTransactionDate, tvTotalPrice;

    public TransactionViewHolder(@NonNull View itemView) {
        super(itemView);
        tvQuantityHistory = itemView.findViewById(R.id.tvQuantityHistory);
        tvFurnitureNameHistory = itemView.findViewById(R.id.tvFurnitureNameHistory);
        tvId = itemView.findViewById(R.id.tvId);
        tvTransactionDate = itemView.findViewById(R.id.tvTransactionDate);
        tvTotalPrice = itemView.findViewById(R.id.tvTotalPrice);

    }
}