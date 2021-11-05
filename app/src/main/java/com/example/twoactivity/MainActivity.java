package com.example.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String ExtraMessage = "com.example.twoactivity.extra.Message";
    private EditText edit_message;
    public static final int Text_Request = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG,"-----");
        Log.d(LOG_TAG,"onCreate");
        edit_message = findViewById(R.id.writeText);
        mReplyHeadTextView = findViewById(R.id.headerINAc1);
        mReplyTextView = findViewById(R.id.show_message);

        //Restore the state
        if(savedInstanceState != null) {
            boolean is_visible = savedInstanceState.getBoolean("reply_visible");
            // if true means we have a reply saved in that instance
            if(is_visible) {
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(savedInstanceState.getString("reply_text"));
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    // call and pass the intent to the second activity and ask for a reply
    public void launch_secondActivity(View view) {
        Log.d(LOG_TAG,"button_clicked!");
        Intent intent = new Intent(this,SecondActivity.class);
        String message = edit_message.getText().toString();
        intent.putExtra(ExtraMessage,message);
        startActivityForResult(intent,Text_Request);
    }

    @Override   // getting result from the second activity
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Text_Request) {
            if(resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    // save the instance of reply message by the user
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(mReplyHeadTextView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text",mReplyTextView.getText().toString());
        }
    }

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
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

}