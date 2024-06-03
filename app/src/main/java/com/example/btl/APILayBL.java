package com.example.btl;


import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class APILayBL extends AsyncTask<Void,Void,Void> {
    String data;
    LayBinhLuanVe layBinhLuanVe;
    String idtruyen;
    public APILayBL(LayBinhLuanVe layBinhLuanVe, String idtruyen) {
        this.layBinhLuanVe = layBinhLuanVe;
        this.layBinhLuanVe.batDau1();
        this.idtruyen=idtruyen;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client= new OkHttpClient();
        Request request=new Request.Builder().url("https://duyanh2002.000webhostapp.com/layBinhLuan.php?id="+idtruyen).build();
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
            this.layBinhLuanVe.biLoi1();
        }else {
            this.layBinhLuanVe.ketThuc1(data);
        }
    }
}
