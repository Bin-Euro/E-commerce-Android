package com.example.ecommerce.product.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    public int id;
    public String tenSP;
    public int hinhSP;
    public int giaSP;
    public String motaSP;

    public SanPham(int id, String tenSP, int hinhSP, int giaSP, String motaSP) {
        this.id = id;
        this.tenSP = tenSP;
        this.hinhSP = hinhSP;
        this.giaSP = giaSP;
        this.motaSP = motaSP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public int getHinhSP() {
        return hinhSP;
    }

    public void setHinhSP(int hinhSP) {
        this.hinhSP = hinhSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(int giaSP) {
        this.giaSP = giaSP;
    }

    public String getMotaSP() {
        return motaSP;
    }

    public void setMotaSP(String motaSP) {
        this.motaSP = motaSP;
    }
}
