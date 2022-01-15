package com.example.project_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    protected static final String EXTRA_REPLY = "com.example.project_4";
    EditText etmain;
    TextView textViewHeader;
    TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        etmain = (EditText) findViewById(R.id.editText_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textViewHeader = (TextView) findViewById(R.id.text_header);
        textViewMessage = (TextView) findViewById(R.id.text_message);
        textViewHeader.setText(message);
    }

    public void lunchFirstActivity(View view) {
        Intent replyIntent = new Intent(this, MainActivity.class);
        String messageMain;
        messageMain = etmain.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY,messageMain);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}