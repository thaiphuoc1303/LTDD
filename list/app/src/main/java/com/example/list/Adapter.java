package com.example.list;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<mathang> listsanpham;
    public  Adapter(Context context, int layout, List<mathang>listsanpham){
        this.context = context;
        this.layout = layout;
        this.listsanpham = listsanpham;

    }
    @Override
    public int getCount() {
        return listsanpham.size();
    }

    @Override
    public Object getItem(int position) {
        return listsanpham.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
        checkBox.setPaintFlags(checkBox.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        mathang newsanpham = listsanpham.get(i);
        checkBox.setText(newsanpham.Ten);

        return convertView;
    }
}
