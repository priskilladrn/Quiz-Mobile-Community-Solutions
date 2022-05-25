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

public class HomeActivity extends AppCompatActivity implements ClickListener {
    RecyclerView recyclerViewProduct;
    TextView tvName, tvEmpty;
    public static ArrayList<Product> products = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewProduct = findViewById(R.id.recyclerViewProduct);

        tvName = findViewById(R.id.tvName);
        tvName.setText(LoginActivity.userLoggedIn.getUserUsername());
        tvEmpty = findViewById(R.id.tvEmpty);
        tvEmpty.setVisibility(View.GONE);

        products.clear();
        dummyData(products);

        ProductAdapter productAdapter = new ProductAdapter(this, products);
        recyclerViewProduct.setAdapter(productAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerViewProduct.setLayoutManager(manager);

        if(productAdapter.getItemCount() == 0){
            recyclerViewProduct.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.VISIBLE);
        }

        productAdapter.setClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void dummyData(ArrayList<Product> products){
        products.add(new Product(1, R.drawable.product1, "Single Sofa", "300000", 3.5));
        products.add(new Product(2, R.drawable.product2, "Long Sofa", "500000", 4.0));
        products.add(new Product(3, R.drawable.product3, "Dining Table", "1000000", 4.3));
        products.add(new Product(4, R.drawable.product4, "Drawer", "800000", 3.8));
        products.add(new Product(5, R.drawable.product5, "Double Bed", "1300000", 4.5));
    }

    @Override
    public void onClick(View view, int position) {
        Integer product = products.get(position).getProductId();
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("productId", product);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.homeMenu:
                break;
            case R.id.transactionMenu:
                intent = new Intent(this, TransactionHistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.profileMenu:
                intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}