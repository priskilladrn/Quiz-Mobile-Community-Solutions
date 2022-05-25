package com.example.insorma_2440110356;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvEmail, tvPhone, tvUsername;
    EditText edtUsername;
    Button btnEditOrSave, btnDelete, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        init();

        tvEmail.setText(LoginActivity.userLoggedIn.userEmailAddress);
        tvUsername.setText(LoginActivity.userLoggedIn.userUsername);
        tvPhone.setText(LoginActivity.userLoggedIn.userPhoneNumber);

        btnEditOrSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnLogout.setOnClickListener(this);

    }

    private void init(){
        tvEmail = findViewById(R.id.tvEmailProfile);
        tvPhone = findViewById(R.id.tvPhoneProfile);
        tvUsername = findViewById(R.id.tvUserNameProfile);
        edtUsername = findViewById(R.id.edtUserNameProfile);
        btnEditOrSave = findViewById(R.id.btnEditOrSave);
        btnDelete = findViewById(R.id.btnDelete);
        btnLogout = findViewById(R.id.btnLogout);
        edtUsername.setVisibility(View.GONE);
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
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if(view == btnEditOrSave){
            if(tvUsername.getVisibility() == view.VISIBLE){
                tvUsername.setVisibility(View.GONE);
                edtUsername.setVisibility(View.VISIBLE);
                btnEditOrSave.setText("Save");
                edtUsername.requestFocus();
            }
            else {
                if (validate()){
                    LoginActivity.userLoggedIn.userUsername = edtUsername.getText().toString();
                    RegisterActivity.users.get(LoginActivity.userIndex).setUserUsername(edtUsername.getText().toString());
                    tvUsername.setText(edtUsername.getText().toString());
                    tvUsername.setVisibility(View.VISIBLE);
                    edtUsername.setVisibility(View.GONE);
                    btnEditOrSave.setText("Edit");
                }
            }
        }
        else if (view == btnDelete){
            int idx = LoginActivity.userIndex;
            RegisterActivity.users.remove(idx);
            LoginActivity.userLoggedIn = null;
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        else if (view == btnLogout){
            LoginActivity.userLoggedIn = null;
            TransactionHistoryActivity.transactions.clear();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    private boolean validate(){
        String username = edtUsername.getText().toString();
        for (int i = 0; i < RegisterActivity.users.size(); i++) {
            String valUsername = RegisterActivity.users.get(i).getUserUsername();

            if (username.isEmpty()){
                edtUsername.requestFocus();
                edtUsername.setError("Field Cannot be Empty!");
                return false;
            }
            if (username.equals(valUsername)) {
                edtUsername.requestFocus();
                edtUsername.setError("This Username is Taken");
                return false;
            }
        }
        return true;
    }
}