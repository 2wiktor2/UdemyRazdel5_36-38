package com.wiktor.udemyrazdel5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextMessage;
    Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMessage = findViewById(R.id.et_massage);
        buttonSend = findViewById(R.id.b_send_message);
        buttonSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String msg = editTextMessage.getText().toString();
        Intent intent = new Intent(this, ReceivedMessageActivity.class);
        intent.putExtra("msg", msg);
        startActivity(intent);
    }
}
