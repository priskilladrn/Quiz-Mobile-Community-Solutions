package com.example.insorma_2440110356;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class TransactionHistoryActivity extends AppCompatActivity {

    RecyclerView recyclerViewTransaction;
    TextView tvNoData;
    public static ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        recyclerViewTransaction = findViewById(R.id.recyclerViewTransaction);

        Intent intent = getIntent();
        tvNoData = findViewById(R.id.tvNoData);
        tvNoData.setVisibility(View.GONE);

        TransactionAdapter transactionAdapter = new TransactionAdapter(this, transactions);
        recyclerViewTransaction.setAdapter(transactionAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerViewTransaction.setLayoutManager(manager);

        if(transactionAdapter.getItemCount() == 0){
            recyclerViewTransaction.setVisibility(View.GONE);
            tvNoData.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.homeMenu:
                intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.transactionMenu:
                break;
            case R.id.profileMenu:
                intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}