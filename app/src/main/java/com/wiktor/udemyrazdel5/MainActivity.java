package com.wiktor.udemyrazdel5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextSubject;
    EditText editTextMessage;
    Button buttonSend;
    Button buttonSendOther;
    Button buttonSendOther2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextSubject = findViewById(R.id.et_subject);
        editTextMessage = findViewById(R.id.et_massage);
        buttonSend = findViewById(R.id.b_send_message);
        buttonSendOther = findViewById(R.id.b_send_message_other);
        buttonSendOther2 = findViewById(R.id.b_send_message_other2);
        buttonSend.setOnClickListener(this);
        buttonSendOther.setOnClickListener(this);
        buttonSendOther2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String sub = editTextSubject.getText().toString();
        String msg = editTextMessage.getText().toString();
        switch (view.getId()) {
            case R.id.b_send_message:
                Intent intent = new Intent(this, ReceivedMessageActivity.class);
                intent.putExtra("msg", msg);
                startActivity(intent);
                break;
            case R.id.b_send_message_other:
                Toast.makeText(this, "Ok", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(Intent.ACTION_SEND); //сказали андроиду что нам нужна активность которая умеет отправлять сообщения
                intent1.setType("text/plain");  // указать тип передаваемого сообщения (простой текст)
                //  Intent.EXTRA_TEXT (это ключ встроенный в андроид, чтобы все знали одинаковые ключи)--- говорит что активность должна уметь обрабатывать данные с типом text/plain и второй аргумент - сам текст
                intent1.putExtra(Intent.EXTRA_TEXT, msg);
                // Передать тему сообщения
                intent1.putExtra(Intent.EXTRA_SUBJECT, sub);
                startActivity(intent1);
                break;
            case R.id.b_send_message_other2:
                Toast.makeText(this, "Ok", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(Intent.ACTION_SEND); //сказали андроиду что нам нужна активность которая умеет отправлять сообщения
                intent2.setType("text/plain");  // указать тип передаваемого сообщения (простой текст)
                //  Intent.EXTRA_TEXT (это ключ встроенный в андроид, чтобы все знали одинаковые ключи)--- говорит что активность должна уметь обрабатывать данные с типом text/plain и второй аргумент - сам текст
                intent2.putExtra(Intent.EXTRA_TEXT, msg);
                // Передать тему сообщения
                intent2.putExtra(Intent.EXTRA_SUBJECT, sub);
                Intent chooserIntent = Intent.createChooser(intent2, getString(R.string.chooser_title));
                startActivity(chooserIntent);
                break;
        }

    }
}
