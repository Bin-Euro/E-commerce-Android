package com.example.ecommerce.product.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ecommerce.R;
import com.example.ecommerce.product.adapter.AdapterMK;
import com.example.ecommerce.product.checkConnection;
import com.example.ecommerce.product.model.SanPham;

import java.util.ArrayList;

public class SanPhamActivity extends AppCompatActivity {
    Toolbar toolbarMK;
    ListView lvMatKinh;
    AdapterMK adapterMK;
    ArrayList<SanPham> arrayMK;
    View footerView;
    boolean isLoading = false;
    int idmk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);
        Anhxa();

        if(checkConnection.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            CatchOnItemListView();
//        LoadmoreData();
            //GetIDDanhSach();
        }else {
            checkConnection.ShowToast_Short(getApplicationContext(),"Vui lòng kiểm tra lại kết nối mạng!");
            finish();
        }

    }

    private void CatchOnItemListView() {
        lvMatKinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(getApplicationContext(), ProductDetailActivity.class);
                intent.putExtra("ProductDetail",arrayMK.get(i));
                startActivity(intent);
            }
        });
    }

//    private void LoadmoreData() {
//        lvMatKinh.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                if (firstVisibleItem +visibleItemCount == totalItemCount && totalItemCount != 0 && isLoading == false) {
//
//                }
//            }
//        });
//    }

    private void GetIDDanhSach() {
        idmk = getIntent().getIntExtra("idDanhSach",-1);
        Log.d("giatridanhsach",idmk + "");
    }

    private void ActionBar() {
        setSupportActionBar(toolbarMK);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarMK.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toolbarMK = (Toolbar) findViewById(R.id.tbSanPham);
        lvMatKinh = (ListView) findViewById(R.id.lvMatKinh);
        arrayMK = new ArrayList<>();
        arrayMK.add(new SanPham(0,"Kính cận EyePlus", R.drawable.kinhcaneyeplus, 400000, "Mắt kính Eye Plus mang kiểu dáng cá tính có điểm nhấn nổi bật nằm ở thiết kế hai bên càng kính. Form dáng cá tính, và độc đáo, thích hợp làm mới vẻ ngoài của người sử dụng."));
        arrayMK.add(new SanPham(0,"Kính Má Hồng", R.drawable.kinhmahong, 300000, "Kính nhiều màu dành cho nữ Kính hai chấm giá rẻ tạo hiệu ứng má hồng dễ thương gọng đen trong suốt hai màu. Tay nghề tinh tế, phối màu hoàn hảo, hiệu ứng hình ảnh tuyệt đẹp, nhiều phong cách rất phù hợp. Thiết kế sản phẩm nhẹ và sang trọng, phù hợp với xu hướng thời trang"));
        arrayMK.add(new SanPham(0,"Kính Râm Retro", R.drawable.kinhramretro, 350000, "Hình dạng khung: Quảng trường. \n" +
                "Lớp bảo vệ tia cực tím: UV400. \n" +
                "Chất liệu khung: Kim loại. \n" +
                "Vật liệu thấu kính: AC. \n" +
                "Chức năng thấu kính: Chống tia cực tím, bảo vệ mắt. \n" +
                "Đối tượng áp dụng: nam và nữ"));
        arrayMK.add(new SanPham(0,"Kính mắt pha lê", R.drawable.kinhmatphale, 500000, "Nhãn hiệu: ORTS. \n" +
                "Loại khung: toàn khung. \n" +
                "Hình dạng khung: hình vuông. \n" +
                "Màu sắc: Nâu. \n" +
                "Trọng lượng: 40 gam. \n" +
                "Độ: + 100,+ 150,+ 200,+ 250,+ 300,+ 350,+ 400. \n" +
                "Phong cách: tinh tế. Phù hợp với hình dạng khuôn mặt: Tất cả các hình dạng khuôn mặt"));
        arrayMK.add(new SanPham(0,"Kính Mát Gọng Vuông", R.drawable.kinhmatgongvuong, 200000, "Các ống kính chất lượng cao sẽ thoải mái hơn. Bảo vệ mắt bên ngoài.\n" +
                "Những người bơi bên ngoài không có áp lực, có thể làm chúng mòn trong một thời gian dài. \n" +
                "Một thiết kế nhẹ nhàng cho mũi của bạn. Một khuôn mặt sang trọng mang lại phong cách. \n" +
                "Màu của sản phẩm có thể gây ra sự khác biệt màu nhờ các màn hình khác nhau, các thiết bị ảnh của sợi quang học khác nhau và các yếu tố khác."));
        arrayMK.add(new SanPham(0,"Kính mát đen", R.drawable.kinhmatden, 200000, "kính mát thời trang Cho nam nữ đi biển Nhỏ kính đen Chống Tia UV400 bảo vệ tia cực tím unisex"));
        arrayMK.add(new SanPham(0,"Kính mát cổ điển", R.drawable.kinhmatcodien, 450000, "Kính loại: kính mát. \n" +
                "Giới tính áp dụng: Unisex. \n" +
                "Phong cách: giản dị, retro, Punk. \n" +
                "Mục đích: dù để che nắng, phù hợp, người phù rể đạo cụ"));
        arrayMK.add(new SanPham(0,"Kính chữ V", R.drawable.kinhgonv, 300000, "Kính râm phân cực retro cho nam, thích hợp khi lái xe, du lịch, câu cá Kính râm retro\n" +
                "Kính râm phân cực retro dành cho nữ, thích hợp cho việc chống nắng, đẹp mắt\n"));
        arrayMK.add(new SanPham(0,"Kính râm phân cực", R.drawable.kinhramphancuc, 350000, "Kính Ma Cà Rồng phân cực retro cho nam, thích hợp khi lái xe, du lịch, câu cá Kính Ma Cà Rồng retro\n" +
                "Kính màu phân cực retro dành cho nữ, thích hợp cho việc chống nắng, đẹp mắt\n"));
        arrayMK.add(new SanPham(0,"Kính cận Hàn Quốc", R.drawable.kinhcan1, 200000, "Kính mắt có độ cận -1.0 đến -6.0 phong cách Hàn Quốc thời trang dành cho cả nam và nữ"));
        adapterMK = new AdapterMK(getApplicationContext(),arrayMK);
        lvMatKinh.setAdapter(adapterMK);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerView = inflater.inflate(R.layout.loadmore_sanpham,null);
    }
}