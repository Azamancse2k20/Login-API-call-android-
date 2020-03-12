package com.example.class09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.class09.LoginActivity.NAME;
import static com.example.class09.LoginActivity.NUMBER;

public class WelcomeActivity extends AppCompatActivity {

    private TextView welcomeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeText =findViewById(R.id.welcomeId);

        Intent intent = getIntent();

        String Name = intent.getStringExtra(NAME);
        String Number = intent.getStringExtra(NUMBER);

        welcomeText.setText("Welcome\n"+Name+"\n"+Number);

    }
}
