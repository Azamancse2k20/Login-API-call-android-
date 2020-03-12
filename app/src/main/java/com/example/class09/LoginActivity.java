package com.example.class09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    public static String NAME = "name";
    public static String NUMBER = "number";

    private Button loginBtn;
    private EditText number, password;
    public static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        number = findViewById(R.id.numberId);
        password = findViewById(R.id.passId);
        loginBtn = findViewById(R.id.loginId);

        apiInterface = ApiCall.getApiClient().create(ApiInterface.class);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();
            }
        });

    }

    private void login() {

        Call<Student> studentCall = apiInterface.login(number.getText().toString(),
                password.getText().toString());

        studentCall.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {

                if (response.body().getResponse().equals("ok")) {

                    String name = response.body().getName();
                    String number = response.body().getNumber();


                    Intent mainActivity = new Intent(LoginActivity.this, WelcomeActivity.class);


                    mainActivity.putExtra(NAME, name);
                    mainActivity.putExtra(NUMBER, number);

                    startActivity(mainActivity);
                    finish();

                    Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {

            }
        }); {

        }

    }

}
