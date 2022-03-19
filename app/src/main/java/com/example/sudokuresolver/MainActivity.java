package com.example.sudokuresolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onConfirmClick(View view) {
        EditText numberOneOne = findViewById(R.id.OneOne);

        TextView txtView = findViewById(R.id.Test12);
        txtView.setText(numberOneOne.getText());
    }
}