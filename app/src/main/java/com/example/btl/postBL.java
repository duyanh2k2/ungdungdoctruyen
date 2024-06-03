package com.example.btl;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class postBL extends AsyncTask<String,Void,String> {
    OkHttpClient okHttpClient=new OkHttpClient.Builder().build();
    String name,noidung,idtruyen;

    public postBL(String name, String noidung, String idtruyen) {
        this.name = name;
        this.noidung = noidung;
        this.idtruyen = idtruyen;
    }

    @Override
    protected String doInBackground(String... strings) {
        RequestBody requestBody=new MultipartBody.Builder()
                .addFormDataPart("name",name)
                .addFormDataPart("noidung",noidung)
                .addFormDataPart("idtruyen",idtruyen)
                .setType(MultipartBody.FORM).build();
        Request request= new Request.Builder().url(strings[0]).post(requestBody).build();
        try {
            Response response =okHttpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d("AAA", s);
        super.onPostExecute(s);
    }
}
