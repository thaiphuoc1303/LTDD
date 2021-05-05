package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ArrayList<mathang> arrlist;
    Adapter adapter;
    Button btThem;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listMatHang);
        arrlist = new ArrayList<>();
        arrlist.add(new mathang("San pham"));
        adapter = new Adapter(this, R.layout.sanpham, arrlist);
        list.setAdapter(adapter);
        btThem = (Button) findViewById(R.id.btThem);
        editText = (EditText) findViewById(R.id.textSpMoi);
        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten =
                        String.valueOf(editText.getText());
                if (ten != ""){
                    arrlist.add(new mathang(ten));
                    adapter = new Adapter(MainActivity.this, R.layout.sanpham, arrlist);
                    list.setAdapter(adapter);
                    editText.setText("");
                }
            }
        });
    }

}