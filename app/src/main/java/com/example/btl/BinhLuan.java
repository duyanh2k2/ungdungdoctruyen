package com.example.btl;

import org.json.JSONException;
import org.json.JSONObject;

public class BinhLuan {
    private String name,noiDung;

    public BinhLuan() {
    }
    public BinhLuan(JSONObject o) throws JSONException {
        this.name=o.getString("name");
        this.noiDung=o.getString("noidung");
    }
    public BinhLuan(String name, String noiDung) {
        this.name = name;
        this.noiDung = noiDung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
