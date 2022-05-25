package com.example.insorma_2440110356;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgProduct;
    TextView tvProductName, tvProductPrice, tvProductRating;
    EditText edtQuantity;
    Button btnBuy;
    Integer productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        init();

        Intent intent = getIntent();
        productId = intent.getIntExtra("productId", 0);

        imgProduct.setImageResource(HomeActivity.products.get(productId-1).getProductImage());
        tvProductName.setText(HomeActivity.products.get(productId-1).getProductName());
        tvProductPrice.setText(HomeActivity.products.get(productId-1).getProductPrice());
        tvProductRating.setText(HomeActivity.products.get(productId-1).getProductRating().toString());

        btnBuy.setOnClickListener(this);

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

    private void init(){
        imgProduct = findViewById(R.id.imgProductDetail);
        tvProductName = findViewById(R.id.tvProductName);
        tvProductPrice = findViewById(R.id.tvProductPrice);
        tvProductRating = findViewById(R.id.tvProductRating);
        edtQuantity = findViewById(R.id.edtProductQuantity);
        btnBuy = findViewById(R.id.btnBuy);
    }

    @Override
    public void onClick(View view) {
        if(view == btnBuy){
            String quantity = edtQuantity.getText().toString();
            String price = tvProductPrice.getText().toString();
            String transactionDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

            if (quantity.isEmpty()){
                edtQuantity.requestFocus();
                edtQuantity.setError("Quantity Must be More Than 0");
                return;
            }
            if(Integer.valueOf(quantity) <= 0){
                edtQuantity.requestFocus();
                edtQuantity.setError("Quantity Must be More Than 0");
                return;
            }
            String totalPrice = "" + Integer.valueOf(price) * Integer.valueOf(quantity);

            ArrayList<Transaction> transactions = TransactionHistoryActivity.transactions;
            transactions.add(new Transaction(transactions.size()+1, LoginActivity.userLoggedIn.userId, productId, quantity + " pcs", transactionDate, tvProductName.getText().toString(), totalPrice));
            Toast.makeText(this, "Bought", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }
}