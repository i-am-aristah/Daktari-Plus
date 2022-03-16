package com.example.daktariplus.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daktariplus.doctormodule.DoctorModuleHome;
import com.example.daktariplus.PatientHomeActivity;
import com.example.daktariplus.R;
import com.example.daktariplus.model.LoginModel;
import com.example.daktariplus.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements  View.OnClickListener{

TextView textView;
Button btnLogin;

EditText edtxtEmail, edtxtPassword;


String SHAREPREFFILE;
SharedPreferences preferences;
SharedPreferences.Editor editor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

textView=findViewById(R.id.txtV_register);
btnLogin = findViewById(R.id.btn_login);
edtxtEmail = findViewById(R.id.edtxt_login_email);
edtxtPassword = findViewById(R.id.edtxt_login_password);


         preferences = getSharedPreferences(SHAREPREFFILE,MODE_PRIVATE);

         editor = preferences.edit();


         if(preferences.getBoolean("login_status",false))
         {
            startActivity(new Intent(getApplicationContext(),PatientHomeActivity.class));
         }

btnLogin.setOnClickListener(this);
textView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btn_login:
                performLogin();
                break;
            case R.id.txtV_register:
                 redirectRegister();
                break;

            default:
                return ;

        }
    }

    //Login User
    private void performLogin() {
        String email= edtxtEmail.getText().toString().toLowerCase();
        String password = edtxtPassword.getText().toString();

        Call<LoginModel> call = ApiClient.getApiService().loginUser(email,password);
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                if(response.isSuccessful())
                {
                    LoginModel loginData = response.body();


                    String user_id = loginData.getId();
                    String user_name = loginData.getName();
                    String token = loginData.getAccess_token();
                    String user_type = loginData.getUser_type();
                    String email = loginData.getEmail();


                    editor.putString("user_id", user_id);
                    editor.putString("username", user_name);
                    editor.putBoolean("login_status", true);
                    editor.putString("token", token);
                    editor.putString("email", email);
                    editor.commit();


                    Intent intent = new Intent(getApplicationContext(), PatientHomeActivity.class);
                    startActivity(intent);
                }
                else {

                   Log.d("RRR",response.message());
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Wrong Login Details",Toast.LENGTH_LONG).show();

            }
        });

    }


    //Redirect to Register Activity
    public void redirectRegister()
    {
        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(i);
    }
}