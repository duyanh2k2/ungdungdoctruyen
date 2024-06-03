package com.example.btl;


import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class APILayChuong extends AsyncTask<Void,Void,Void> {
    String data;
    LayChuongVe layChuongVe;
    String idtruyen;
    public APILayChuong(LayChuongVe layChuongVe,String idtruyen) {
        this.layChuongVe = layChuongVe;
        this.layChuongVe.batDau();
        this.idtruyen=idtruyen;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client= new OkHttpClient();
        Request request=new Request.Builder().url("https://duyanh2002.000webhostapp.com/layChuong.php?id="+idtruyen).build();
        data=null;
        try{
            Response response = client.newCall(request).execute();
            ResponseBody body= response.body();
            data=body.string();
        } catch (IOException e){
            data=null;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        if(data==null){
            this.layChuongVe.biLoi();
        }else {
            this.layChuongVe.ketThuc(data);
        }
    }
}
