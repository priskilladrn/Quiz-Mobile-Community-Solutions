package com.example.insorma_2440110356;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionViewHolder>{
    Context _context;
    ArrayList<Transaction> _transactions;

    public TransactionAdapter(Context context, ArrayList<Transaction> transactions){
        _context = context;
        _transactions = transactions;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(_context)
                .inflate(R.layout.layout_transaction, parent, false);

        TransactionViewHolder viewHolder = new TransactionViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Integer transactionId = _transactions.get(position).transactionId;
        String quantity = _transactions.get(position).quantity;
        String furnitureName = _transactions.get(position).productName;
        String transactionDate = _transactions.get(position).transactionDate;
        String totalPrice = _transactions.get(position).totalPrice;

        holder.tvId.setText(transactionId.toString());
        holder.tvQuantityHistory.setText(quantity);
        holder.tvFurnitureNameHistory.setText(furnitureName);
        holder.tvTransactionDate.setText(transactionDate);
        holder.tvTotalPrice.setText(totalPrice);

    }

    @Override
    public int getItemCount() {
        return _transactions.size();
    }
}
