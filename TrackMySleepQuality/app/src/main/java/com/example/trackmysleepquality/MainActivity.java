package com.example.trackmysleepquality;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_start, btn_stop, btn_clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_clear = (Button) findViewById(R.id.clear_button);
        btn_start = (Button) findViewById(R.id.start_button);
        btn_stop = (Button) findViewById(R.id.stop_button);

    }
}