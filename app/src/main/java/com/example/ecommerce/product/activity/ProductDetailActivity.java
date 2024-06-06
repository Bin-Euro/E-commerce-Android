package com.example.ecommerce.product.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.chaythu.R;
import com.example.chaythu.model.SanPham;

import java.text.DecimalFormat;

public class ProductDetailActivity extends AppCompatActivity {
    Toolbar tbDetail;
    ImageView imgDetail;
    TextView tvTenDetail, tvGiaDetail, tvMotaDetail;
    Spinner spinner;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Anhxa();
//        ActionBar();
        GetInformation();
        CatchEventSpinner();
    }

    private void CatchEventSpinner() {
        Integer[] soluong = new Integer[] {1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,soluong);
        spinner.setAdapter(arrayAdapter);
    }

    private void GetInformation() {
        int id = 0 ;
        String TenDetail = "";
        int GiaDetail = 0;
        int HinhDetail = 0;
        String MotaDetail = "";
        int idMK = 0;
        SanPham sanpham = (SanPham) getIntent().getSerializableExtra("ProductDetail");
        id = sanpham.getId();
        TenDetail = sanpham.getTenSP();
        GiaDetail = sanpham.getGiaSP();
        HinhDetail = sanpham.getHinhSP();
        MotaDetail = sanpham.getMotaSP();
        tvTenDetail.setText(TenDetail);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tvGiaDetail.setText("Giá: " + decimalFormat.format(GiaDetail) + "vnđ");
        tvMotaDetail.setText(MotaDetail);
        imgDetail.setImageResource(HinhDetail);
    }

    private void ActionBar() {
        setSupportActionBar(tbDetail);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        tbDetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        tbDetail = (Toolbar) findViewById(R.id.tbDetail);
        imgDetail = (ImageView) findViewById(R.id.imgDetail);
        tvTenDetail = (TextView) findViewById(R.id.tvTenDetail);
        tvGiaDetail = (TextView) findViewById(R.id.tvGiaDeTail);
        tvMotaDetail = (TextView) findViewById(R.id.tvMoTaDetail);
        spinner = (Spinner) findViewById(R.id.spinner);
        btnAdd = (Button) findViewById(R.id.btnBuy);
    }
}