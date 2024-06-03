package com.example.btl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Truyen implements Serializable {
    private String id, linkAnh, tenTruyen;

    public Truyen() {
    }

    public Truyen(JSONObject o) throws JSONException {
        id = o.getString("id");
        linkAnh = o.getString("linkAnh");
        tenTruyen = o.getString("tenTruyen");
    }

    public Truyen(String linkAnh, String tenTruyen) {
        this.linkAnh = linkAnh;
        this.tenTruyen = tenTruyen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        this.linkAnh = linkAnh;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }
}

