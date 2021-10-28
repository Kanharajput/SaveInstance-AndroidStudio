package com.example.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String Log_Tag = MainActivity.class.getSimpleName();
    public static final String ExtraMessage = "com.example.twoactivity.extra.Message";
    private EditText edit_message;
    public static final int Text_Request = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_message = findViewById(R.id.writeText);
        mReplyHeadTextView = findViewById(R.id.headerINAc1);
        mReplyTextView = findViewById(R.id.show_message);
    }

    public void launch_secondActivity(View view) {
        Log.d(Log_Tag,"button_clicked!");
        Intent intent = new Intent(this,SecondActivity.class);
        String message = edit_message.getText().toString();
        intent.putExtra(ExtraMessage,message);
        startActivityForResult(intent,Text_Request);
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Text_Request){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}