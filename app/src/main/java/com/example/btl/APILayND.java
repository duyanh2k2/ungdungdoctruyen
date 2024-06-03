package com.example.btl;


import android.os.AsyncTask;
import android.view.View;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class APILayND extends AsyncTask<Void,Void,Void> {
    String data;
    LayNDve layNDve;
    String idChuong;
    public APILayND(LayNDve layNDve, String idChuong) {
        this.layNDve = layNDve;
        this.idChuong=idChuong;
        this.layNDve.batDau();
    }
    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client= new OkHttpClient();
        Request request=new Request.Builder().url("https://duyanh2002.000webhostapp.com/layNoiDung.php?idChuong="+idChuong).build();
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
            this.layNDve.biLoi();
        }else {
            this.layNDve.ketThuc(data);
        }
    }
}
