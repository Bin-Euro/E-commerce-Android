package com.example.ecommerce.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AdapterSP extends RecyclerView.Adapter<AdapterSP.ViewHolder> {
    Context context;
    ArrayList<SanPham> arraySP;

    public AdapterSP(Context context, ArrayList<SanPham> arraySP) {
        this.context = context;
        this.arraySP = arraySP;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recylerview_bestseller, null);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        SanPham sanpham = arraySP.get(i);
        holder.tvTenSP.setText(sanpham.getTenSP());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.tvGiaSP.setText("Giá: " + decimalFormat.format(sanpham.getGiaSP()) + "vnđ");
        holder.imgHinhSP.setImageResource(sanpham.hinhSP);
    }

    @Override
    public int getItemCount() {
        return arraySP.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgHinhSP;
        public TextView tvTenSP, tvGiaSP;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imgHinhSP = (ImageView) itemView.findViewById(R.id.imgSanPham);
            tvTenSP = (TextView) itemView.findViewById(R.id.tvTenSP);
            tvGiaSP = (TextView) itemView.findViewById(R.id.tvGiaSP);
        }
    }
}
