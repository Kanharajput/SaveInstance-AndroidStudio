package com.example.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView text_view;
    public static final String EXTRA_REPLY = "com.example.twoactivity.extra.REPLY";
    private EditText reply_by_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // getting id where we have to show the message
        text_view = findViewById(R.id.message_by_user);
        // getting passed intent
        Intent intent = getIntent();
        // getting message of user with the help of key
        String message = intent.getStringExtra(MainActivity.ExtraMessage);
        // at the last set that message on the element which we find by id
        text_view.setText(message);

        // Below code is for getting a reply pass to the main activity
        reply_by_user = findViewById(R.id.reply_message_id);
    }

    public void returnReply(View view){
        // reply by user at second activity
        String reply_message = reply_by_user.getText().toString();

        Intent repIntent = new Intent();
        repIntent.putExtra(EXTRA_REPLY,reply_message);
        setResult(RESULT_OK,repIntent);
        finish();
    }
}