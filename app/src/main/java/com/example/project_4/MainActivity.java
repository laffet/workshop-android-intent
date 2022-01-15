package com.example.project_4;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    protected static final String EXTRA_MESSAGE = "com.example.project_4";
    private static final int TEXT_REQUEST = 1;
    EditText etmain;
    TextView textViewReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etmain = (EditText) findViewById(R.id.editText_main);
    }

    public void lunchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String messageMain;
        messageMain = etmain.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, messageMain);
        startActivityForResult(intent, TEXT_REQUEST);
        Log.d(LOG_TAG, "Button clicked");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) { ;
                String message = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                textViewReply = (TextView) findViewById(R.id.text_reply);
                textViewReply.setText(message);
            }
        }
    }
}