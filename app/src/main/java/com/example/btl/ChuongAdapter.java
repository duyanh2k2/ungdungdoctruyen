package com.example.btl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ChuongAdapter extends ArrayAdapter<ChuongTruyen> {
    Context context;
    ArrayList<ChuongTruyen> arr;
    public ChuongAdapter(@NonNull Context context, int resource, @NonNull List<ChuongTruyen> objects) {
        super(context, resource, objects);
        this.context=context;
        this.arr=new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_chuong,parent,false);
        }
        if(arr.size()>0){
            TextView chuongtruyen,ngaydang;
            chuongtruyen=convertView.findViewById(R.id.chuong);
            ngaydang = convertView.findViewById(R.id.ngaydang);

            ChuongTruyen chuongTruyen= arr.get(position);
            chuongtruyen.setText(chuongTruyen.getChuong());
            ngaydang.setText(chuongTruyen.getNgayDang());
        }
        return convertView;
    }
}
