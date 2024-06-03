package com.example.btl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements LayChuongVe /*,LayBinhLuanVe*/ {
    ImageView Anh;
    TextView tenTruyen;
    Truyen truyen;
    ListView chuongtruyen;
    ArrayList<ChuongTruyen> ls;
    ChuongAdapter chuongAdapter;
    //EditText user,noidung;
    //Button gui;
    //ListView lvBinhLuan;
    //ArrayList<BinhLuan> lsbl;
    //BinhLuanAdapter binhLuanAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        anhxa();
        setUp();
        setOnClick();
        new APILayChuong(this,truyen.getId()).execute();
        //new APILayBL(this,truyen.getId()).execute();
    }
    private void init(){
        Bundle bundle=getIntent().getBundleExtra("data");
        truyen=(Truyen) bundle.getSerializable("Truyen");
        ls=new ArrayList<>();
        //lsbl=new ArrayList<>();
    }
    private void anhxa(){
        Anh=findViewById(R.id.anh);
        tenTruyen=findViewById(R.id.tentruyen);
        chuongtruyen=findViewById(R.id.chuongtruyen);
        //user=findViewById(R.id.user);
        //noidung=findViewById(R.id.noidung);
        //gui=findViewById(R.id.gui);
        //lvBinhLuan=findViewById(R.id.lvbinhluan);

    }
    private void setUp(){
        Glide.with(this).load(truyen.getLinkAnh()).into(Anh);
        tenTruyen.setText(truyen.getTenTruyen());
    }
    private void setOnClick(){
        chuongtruyen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle b=new Bundle();
                b.putString("idchuong",ls.get(i).getId());
                Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                intent.putExtra("data",b);
                startActivity(intent);
            }
        });

//        gui.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String name=user.getText().toString().trim();
//                String nd=noidung.getText().toString().trim();
//                new postBL(name,nd,truyen.getId()).execute("https://duyanh2002.000webhostapp.com/insertBL.php");
//                user.setText("");
//                noidung.setText("");
//            }
//        });
    }

    @Override
    public void batDau() {
        Toast.makeText(this,"dang lay du lieu",Toast.LENGTH_LONG).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            ls.clear();
            JSONArray arr = new JSONArray(data);
            for (int i=0;i<arr.length();i++){
                ChuongTruyen c= new ChuongTruyen(arr.getJSONObject(i));
                ls.add(c);
            }
            chuongAdapter=new ChuongAdapter(this,0,ls);
            chuongtruyen.setAdapter(chuongAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void biLoi() {
        Toast.makeText(this,"loi ket noi",Toast.LENGTH_LONG).show();
    }

//    @Override
//    public void batDau1() {
//
//    }
//
//    @Override
//    public void ketThuc1(String data) {
//        lsbl.clear();
//        try {
//            JSONArray j= new JSONArray(data);
//            for (int i=0;i<j.length();i++){
//                BinhLuan binhLuan=new BinhLuan(j.getJSONObject(i));
//                lsbl.add(binhLuan);
//            }
//            binhLuanAdapter=new BinhLuanAdapter(this,0,lsbl);
//            lvBinhLuan.setAdapter(binhLuanAdapter);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void biLoi1() {
//
//    }
}