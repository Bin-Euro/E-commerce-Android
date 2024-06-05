package com.example.ecommerce.product;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.R;
import com.example.ecommerce.product.AdapterDS;
import com.example.ecommerce.product.AdapterSP;
import com.example.ecommerce.product.DanhSach;
import com.example.ecommerce.product.SanPham;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    NavigationView navigationView;
    ListView lvDanhSach;
    ArrayList<DanhSach> arrayDanhSach;
    AdapterDS adapterDS;
    ArrayList<SanPham> arraySanPham;
    AdapterSP adapterSP;
    //    int id;
//    String tenSP="";
//    String anhSP="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_list);
        Anhxa();

        if (checkConnection.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            ActionViewFlipper();
        }else {
            checkConnection.ShowToast_Short(getApplicationContext(), "Vui lòng kiểm tra lại kết nối mạng");
        }
    }

    private void ActionViewFlipper() {
        ArrayList<String> arrayAD = new ArrayList<String>();
        arrayAD.add("file:///D:/%E1%BA%A2nh/1.htm");
        arrayAD.add("file:///D:/%E1%BA%A2nh/2.htm");
        arrayAD.add("file:///D:/%E1%BA%A2nh/3.htm");
        for (int i = 0; i<arrayAD.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ani_in);
        Animation animation_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ani_out);
        viewFlipper.setInAnimation(animation_in);
        viewFlipper.setOutAnimation(animation_out);
    }

    private void ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    private void Anhxa() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbarProduct);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        recyclerView = (RecyclerView) findViewById(R.id.rcvBestSeller);
        lvDanhSach = (ListView) findViewById(R.id.lvDanhSach);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        arrayDanhSach = new ArrayList<>();
        arrayDanhSach.add(0, new DanhSach(0,"Trang chủ",R.drawable.home));
        arrayDanhSach.add(1, new DanhSach(0,"Sản phẩm",R.drawable.glasses));
        arrayDanhSach.add(2, new DanhSach(0,"Thông tin",R.drawable.profile));
        arrayDanhSach.add(3, new DanhSach(0,"Chat",R.drawable.talk));
        adapterDS = new AdapterDS(arrayDanhSach,getApplicationContext(),R.layout.lis_view_danhsach);
        lvDanhSach.setAdapter(adapterDS);
        arraySanPham = new ArrayList<>();
        arraySanPham.add(new SanPham(0, "Combo 6 kính mắt chống UV", R.drawable.kinh_1,800000, "Siêu bền, hợp kim rắn chắc, mọi thứ đều tốt"));
        arraySanPham.add(new SanPham(0, "Mắt kính râm", R.drawable.kinh_2,250000, "Siêu bền, nhựa dẻo không gãy, mọi thứ đều tốt"));
        arraySanPham.add(new SanPham(0, "Mắt kính gọng tròn", R.drawable.kinh_3,200000, "Siêu bền, hợp kim rắn chắc, mọi thứ đều tốt"));
        arraySanPham.add(new SanPham(0, "Mắt kính 4", R.drawable.kinh4,200000, "Siêu bền, hợp kim rắn chắc, mọi thứ đều tốt"));
        adapterSP = new AdapterSP(getApplicationContext(), arraySanPham);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(adapterSP);
    }
}