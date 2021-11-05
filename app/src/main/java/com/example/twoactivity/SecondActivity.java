package com.example.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView text_view;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
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
        Log.d(LOG_TAG,"Returning to the first Activity");
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }

    // lifecycle callbacks
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }

}