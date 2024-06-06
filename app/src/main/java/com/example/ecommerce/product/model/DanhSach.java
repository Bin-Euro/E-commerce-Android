package com.example.ecommerce.product.model;

public class DanhSach {
    public  int id;
    public String tenSP;
    public int hinhSP;

    public DanhSach(int id, String tenSP, int hinhSP) {
        this.id = id;
        this.tenSP = tenSP;
        this.hinhSP = hinhSP;
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

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getHinhSP() {
        return hinhSP;
    }

    public void setHinhSP(int hinhSP) {
        this.hinhSP = hinhSP;
    }
}
