package com.example.daktariplus.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daktariplus.R;
import com.example.daktariplus.model.User;
import com.example.daktariplus.model.UserModel;
import com.example.daktariplus.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    TextView txtLogin;
    Button btnRegister;
    EditText edtxtUsername, edtxtPassword, edtxtEmail, edtxtConfirmpassword;
    UserModel user;
    User userdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        init();


         btnRegister.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String username = edtxtUsername.getText().toString();
                 String password = edtxtPassword.getText().toString();
                 String email = edtxtEmail.getText().toString();
                 String confirmpassword = edtxtConfirmpassword.getText().toString();
                 if(username.equals(""))
                 {
                     edtxtUsername.setError("userName is Required");
                 }
                 else if(email.equals(""))
                 {
                     edtxtEmail.setError("Email is Required");
                 }
                 else if(password.equals(""))
                 {
                     edtxtPassword.setError("Password is Required");
                 }

                  else {

                      //Network call to register user to system
                      Call<UserModel> call = ApiClient.getApiService().registerUser(username, email, password, confirmpassword);

                      call.enqueue(new Callback<UserModel>() {
                          @Override
                          public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                              user = response.body();
                              userdata = user.getUser();

                              if (response.isSuccessful()) {
                                  Toast.makeText(getApplicationContext(), user.getToken(), Toast.LENGTH_LONG).show();
                              }


                          }

                          @Override
                          public void onFailure(Call<UserModel> call, Throwable t) {

                              Log.d("TAGG",t.getMessage());

                          }
                      });
                  }

             }
         });


        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public void init()
    {
        txtLogin = findViewById(R.id.txtV_sign_in);
        btnRegister=findViewById(R.id.btn_reg_signup);
        edtxtUsername=findViewById(R.id.edttxt_reg_usename);
        edtxtPassword=findViewById(R.id.edttxt_reg_password);
        edtxtEmail=findViewById(R.id.edttxt_reg_email);
        edtxtConfirmpassword=findViewById(R.id.edttxt_reg_confirmpassword);
    }
}