package com.example.ecommerce.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDS extends BaseAdapter {
    private ArrayList<DanhSach> arrayDanhSach;
    private Context context;
    private int layout;

    public AdapterDS(ArrayList<DanhSach> arrayDanhSach, Context context, int layout) {
        this.arrayDanhSach = arrayDanhSach;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return arrayDanhSach.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayDanhSach.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view =inflater.inflate(layout, null);
        TextView tvDanhSach= (TextView) view.findViewById(R.id.tvDanhSach);
        ImageView imgDanhSach = (ImageView) view.findViewById(R.id.imageViewLoaiSP);
        DanhSach danhsach = arrayDanhSach.get(i);
        tvDanhSach.setText(danhsach.tenSP);
        imgDanhSach.setImageResource(danhsach.hinhSP);
        return view;
    }
}
