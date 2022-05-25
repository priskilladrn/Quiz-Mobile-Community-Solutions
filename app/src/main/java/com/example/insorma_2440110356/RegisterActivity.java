package com.example.insorma_2440110356;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtEmail, edtUsername, edtPhone, edtPassword;
    Button btnRegister,btnLogin;
    Integer userId;
    public static ArrayList<User> users = new ArrayList<User>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    private void init(){
        edtEmail = findViewById(R.id.edtEmail);
        edtUsername = findViewById(R.id.edtUsername);
        edtPhone = findViewById(R.id.edtPhone);
        edtPassword = findViewById(R.id.edtPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
    }

    @Override
    public void onClick(View view) {
        if(view == btnLogin){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        else if(view == btnRegister){
            if(validation()){
                Toast.makeText(getApplicationContext(), "Sign Up Successful!", Toast.LENGTH_SHORT).show();
                userId = users.size() + 1;
                users.add(new User(userId, edtEmail.getText().toString(), edtUsername.getText().toString(), edtPhone.getText().toString(), edtPassword.getText().toString()));

                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }
        }
    }

    private boolean validation(){
        String username = edtUsername.getText().toString();
        String email = edtEmail.getText().toString();
        String phone = edtPhone.getText().toString();
        String password = edtPassword.getText().toString();

        if(username.isEmpty()){
            edtUsername.requestFocus();
            edtUsername.setError("Field Cannot be Empty!");
            return false;
        }
        if(username.length() < 3 || username.length() > 20){
            edtUsername.requestFocus();
            edtUsername.setError("Must be Between 3 and 20 Characters");
            return false;
        }
        if(phone.isEmpty()){
            edtPhone.requestFocus();
            edtPhone.setError("Field Cannot be Empty!");
            return false;
        }
        if(email.isEmpty()){
            edtEmail.requestFocus();
            edtEmail.setError("Field Cannot be Empty!");
            return false;
        }
        if(!email.endsWith(".com")){
            edtEmail.requestFocus();
            edtEmail.setError("Must end with .com");
            return false;
        }
        if(password.isEmpty()){
            edtPassword.requestFocus();
            edtPassword.setError("Field Cannot be Empty!");
            return false;
        }
        if(!password.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$")){
            edtPassword.requestFocus();
            edtPassword.setError("Must Contain Letters and Numbers");
            return false;
        }
        if(users.size() > 0){
            for (int i = 0; i < users.size(); i++){
                String valEmail = users.get(i).getUserEmailAddress();
                String valUsername = users.get(i).getUserUsername();

                if(username.equals(valUsername)){
                    edtUsername.requestFocus();
                    edtUsername.setError("This Username is Taken");
                    return false;
                }
                if(email.equals(valEmail)){
                    edtEmail.requestFocus();
                    edtEmail.setError("This Email is Taken");
                    return false;
                }
            }
        }
        return true;
    }
}