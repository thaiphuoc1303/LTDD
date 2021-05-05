package com.example.notifition;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    DataBase dataBase;
    ArrayList<monhoc> monhocs;
    ListView list;
    MonHocAdapter adapter;
    Menu menu;
    ImageButton btnReload;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumain, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.map:
                Intent intentMap = new Intent(this, MapActivity.class);
                startActivity(intentMap);
                break;
            case R.id.danhsach:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        list = (ListView) findViewById(R.id.listview);
        btnReload = (ImageButton) findViewById(R.id.imgbtnReload);
        dataBase = new DataBase(this, "database.sqlite", null, 1);
        dataBase.QueryData("CREATE TABLE IF NOT EXISTS lichhoc (" +
                "    id        INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    thu       INTEGER," +
                "    hocphan   VARCHAR," +
                "    phong     VARCHAR," +
                "    thoigian, VARCHAR" +
                "    trangthai INTEGER DEFAULT (0)" +
                ")");
        Cursor cursor = dataBase.GetData("SELECT * FROM lichhoc");
        monhocs = new ArrayList<>();
        int i =0;
        while (cursor.moveToNext()){
            i++;
            String id = cursor.getString(0);
            String thu = cursor.getString(1);
            String mon = cursor.getString(2);
            String phong =cursor.getString(3);
            String thoiGian = cursor.getString(4);

                monhocs.add(new monhoc(id, mon, phong, thu, thoiGian, i+""));

        }
            adapter = new MonHocAdapter(this, R.layout.monhoc, monhocs);
            list.setAdapter(adapter);
        Intent intent = new Intent(this, ServiceNotification.class);
        startService(intent);
        btnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor2 = dataBase.GetData("SELECT * FROM lichhoc");
                monhocs.clear();
                int j =0;
                while (cursor2.moveToNext()){
                    j++;
                    String id = cursor2.getString(0);
                    String thu = cursor2.getString(1);
                    String mon = cursor2.getString(2);
                    String phong = cursor2.getString(3);
                    String thoiGian = cursor2.getString(4);

                    monhocs.add(new monhoc(id, mon, phong, thu, thoiGian, j+""));

                }
                adapter.notifyDataSetChanged();

            }
        });
    }
}