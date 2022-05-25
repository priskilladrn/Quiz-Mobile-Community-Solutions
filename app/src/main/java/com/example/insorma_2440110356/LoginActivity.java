package com.example.insorma_2440110356;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtEmail, edtPassword;
    Button btnLogin, btnRegister;
    public static User userLoggedIn;
    public static int userIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    private void init(){
        edtEmail = findViewById(R.id.edtEmail2);
        edtPassword = findViewById(R.id.edtPassword2);
        btnLogin = findViewById(R.id.btnLogin2);
        btnRegister = findViewById(R.id.btnRegister2);
    }

    @Override
    public void onClick(View view) {
        if(view == btnLogin){
            String email = edtEmail.getText().toString();
            String password = edtPassword.getText().toString();
            val(email, password);
        }
        else if(view == btnRegister){
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
    }

    private void val(String valEmail, String valPass){
        boolean cek = false;
        if(valEmail.isEmpty()){
            edtEmail.requestFocus();
            edtEmail.setError("Field Cannot be Empty!");
            return;
        }
        if(valPass.isEmpty()){
            edtPassword.requestFocus();
            edtPassword.setError("Field Cannot be Empty!");
            return;
        }
        for (int i = 0; i < RegisterActivity.users.size(); i++){
            String email = RegisterActivity.users.get(i).getUserEmailAddress();
            String password = RegisterActivity.users.get(i).getUserPassword();
            Integer userId = RegisterActivity.users.get(i).getUserId();
            String username = RegisterActivity.users.get(i).getUserUsername();
            String phone = RegisterActivity.users.get(i).getUserPhoneNumber();

            if(valEmail.equals(email) && valPass.equals(password)){
                cek = true;
                userLoggedIn = new User(userId, email, username , phone , password);
                userIndex = i;
                break;
            }
        }
        if(cek){
            Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        }
        else{
            edtPassword.requestFocus();
            edtPassword.setError("Email and Password didn't match");
            return;
        }
    }
}