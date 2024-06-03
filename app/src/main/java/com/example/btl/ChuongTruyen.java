package com.example.btl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class ChuongTruyen implements Serializable {
    private String chuong,ngayDang,id;

    public ChuongTruyen(JSONObject o) throws JSONException {
        chuong= o.getString("chuong");
        ngayDang = o.getString("ngayDang");
        id=o.getString("id");
    }
    public ChuongTruyen() {
    }

    public ChuongTruyen(String chuong, String ngayDang) {
        this.chuong = chuong;
        this.ngayDang = ngayDang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChuong() {
        return chuong;
    }

    public void setChuong(String chuong) {
        this.chuong = chuong;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }
}
