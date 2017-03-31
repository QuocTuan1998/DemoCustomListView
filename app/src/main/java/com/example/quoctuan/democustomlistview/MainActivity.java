package com.example.quoctuan.democustomlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quoctuan.democustomlistview.adapter.AdapterDanhSach;
import com.example.quoctuan.democustomlistview.model.DanhSach;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtDanhSach;

    ListView lvDanhSach;
    ArrayList<DanhSach> listDS;
    AdapterDanhSach adapterDanhSach;

    DanhSach danhSach;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = listDS.get(position).getTen();
                txtDanhSach.setText(t);
            }
        });

    }

    private void addControls() {

        txtDanhSach = (TextView) findViewById(R.id.txtDanhSach);

        lvDanhSach = (ListView) findViewById(R.id.lvDanhSach);
        listDS = new ArrayList<>();
        listDS.add(new DanhSach("Hà Nội"));
        listDS.add(new DanhSach("Huế"));
        listDS.add(new DanhSach("Hải Phòng"));
        listDS.add(new DanhSach("Spa"));
        listDS.add(new DanhSach("Côn Sơn"));
        adapterDanhSach = new AdapterDanhSach(
                                        MainActivity.this,
                                        R.layout.item,
                                        listDS);
        lvDanhSach.setAdapter(adapterDanhSach);

    }
}
