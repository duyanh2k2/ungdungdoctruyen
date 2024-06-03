package com.example.btl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TruyenAdapter extends ArrayAdapter<Truyen> {
    private Context context;
    private ArrayList<Truyen> truyen;

    public TruyenAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Truyen> objects) {
        super(context, resource, objects);
        this.context=context;
        this.truyen=objects;
    }
    public void SXTruyen(String s){
        s=s.toUpperCase();
        int k=0;
        for(int i=0; i<truyen.size();i++){
            Truyen a= truyen.get(i);
            String tentruyen=a.getTenTruyen().toUpperCase();
            if(tentruyen.indexOf(s)>=0){
                truyen.set(i,truyen.get(k));
                truyen.set(k,a);
                k++;
            }
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
           convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_truyen,parent,false);
        }
        if(truyen.size()>0){
            Truyen truyen1=this.truyen.get(position);
            ImageView linkanh =convertView.findViewById(R.id.linkanh);
            TextView tentruyen = convertView.findViewById(R.id.tentruyen);
            Glide.with(this.context).load(truyen1.getLinkAnh()).into(linkanh);
            tentruyen.setText(truyen1.getTenTruyen());
        }
        return convertView;
    }
}
