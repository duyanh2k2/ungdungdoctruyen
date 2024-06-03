package com.example.btl;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LayTruyenVe{
    GridView gridView;
    TruyenAdapter truyenAdapter;
    ArrayList<Truyen> arr;
    EditText timkiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhxa();
        setup();
        setOnClick();
        new APILayTruyen(this).execute();
    }
    private void init(){
        arr=new ArrayList<>();
        truyenAdapter=new TruyenAdapter(this,0,arr);
    }
    private void anhxa(){
        gridView=findViewById(R.id.truyen);
        timkiem=findViewById(R.id.timkiem);
    }
    private void setup(){
        gridView.setAdapter(truyenAdapter);
    }
    private void setOnClick(){
        timkiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s =editable.toString();
                truyenAdapter.SXTruyen(s);
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Truyen t = arr.get(i);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Truyen",t);
                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("data",bundle);
                startActivity(intent);
            }
        });
    }
    @Override
    public void batDau() {
        Toast.makeText(this,"Dang lay du lieu",Toast.LENGTH_LONG).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            arr.clear();
            JSONArray jarr = new JSONArray(data);
            for (int i=0; i<jarr.length();i++){
                JSONObject o = jarr.getJSONObject(i);
                arr.add(new Truyen(o));
            }
            truyenAdapter=new TruyenAdapter(this,0,arr);
            gridView.setAdapter(truyenAdapter);
        } catch (JSONException e){

        }
    }

    @Override
    public void biLoi() {
        Toast.makeText(this,"Loi ket noi",Toast.LENGTH_LONG).show();
    }
//    ActivityResultLauncher<Intent> a = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
//        @Override
//        public void onActivityResult(ActivityResult result) {
//
//        }
//    });

}