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

public class BinhLuanAdapter extends ArrayAdapter<BinhLuan> {
    Context context;
    ArrayList<BinhLuan> arr;
    public BinhLuanAdapter(@NonNull Context context, int resource, @NonNull List<BinhLuan> objects) {
        super(context, resource, objects);
        this.context=context;
        this.arr=new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout,parent,false);
        }
        if(arr.size()>0){
            TextView user,noidung;
            user=convertView.findViewById(R.id.name);
            noidung=convertView.findViewById(R.id.txtnd);
            BinhLuan binhLuan = arr.get(position);
            user.setText(binhLuan.getName());
            noidung.setText(binhLuan.getNoiDung());
        }
        return convertView;
    }
}
