package com.example.ecommerce.product.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.ecommerce.R;
import com.example.ecommerce.product.model.SanPham;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AdapterMK extends BaseAdapter {
    Context context;
    ArrayList<SanPham> arrayMatKinh;

    public AdapterMK(Context context, ArrayList<SanPham> arrayMatKinh) {
        this.context = context;
        this.arrayMatKinh = arrayMatKinh;
    }

    @Override
    public int getCount() {
        return arrayMatKinh.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayMatKinh.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
        public TextView tvTenMK, tvGiaMK, tvMoTaMK;
        public ImageView imgMatKinh;
    }
    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_matkinh, null);
            viewHolder.tvTenMK =(TextView) view.findViewById((R.id.tvMatKinh));
            viewHolder.tvGiaMK =(TextView) view.findViewById((R.id.tvGiaMK));
            viewHolder.tvMoTaMK =(TextView) view.findViewById((R.id.tvMoTaMK));
            viewHolder.imgMatKinh =(ImageView) view.findViewById((R.id.imvMatKinh));
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        SanPham sanpham = (SanPham) getItem(i);
        viewHolder.tvTenMK.setText(sanpham.getTenSP());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.tvGiaMK.setText("Giá: " + decimalFormat.format(sanpham.getGiaSP()) + "vnđ");
        viewHolder.tvMoTaMK.setMaxLines(2);
        viewHolder.tvMoTaMK.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.tvMoTaMK.setText(sanpham.getMotaSP());
        viewHolder.imgMatKinh.setImageResource(sanpham.getHinhSP());
        return view;
    }
}
