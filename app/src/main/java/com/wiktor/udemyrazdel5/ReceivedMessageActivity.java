package com.wiktor.udemyrazdel5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceivedMessageActivity extends AppCompatActivity {
    TextView textViewMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_message);

        textViewMessage = findViewById(R.id.tv_received_message);
        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");

        textViewMessage.setText(msg);
    }
}
