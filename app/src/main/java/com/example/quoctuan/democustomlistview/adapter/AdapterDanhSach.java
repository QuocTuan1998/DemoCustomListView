package com.example.quoctuan.democustomlistview.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quoctuan.democustomlistview.R;
import com.example.quoctuan.democustomlistview.model.DanhSach;

import java.util.List;

/**
 * Created by Tuan on 3/29/2017.
 */

public class AdapterDanhSach extends ArrayAdapter{
    Activity context;
    @LayoutRes int resource;
    @NonNull List objects;
    public AdapterDanhSach(@NonNull Activity context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View row = layoutInflater.inflate(this.resource,null);

        TextView txtDanhSach = (TextView) row.findViewById(R.id.txtDanhSach);
        TextView txtHinh = (TextView) row.findViewById(R.id.txtHinh);
        ImageView imgHinh = (ImageView) row.findViewById(R.id.imgHinh);

        DanhSach ds = (DanhSach) this.objects.get(position);

        if (position == 0){
            txtHinh.setText("Hà Nội");
        }
        else if (position == 1){
            txtHinh.setText("Huế");
        }
        else if (position == 2){
            txtHinh.setText("Spa");
        }
        else if (position == 3){
            txtHinh.setText("Côn Sơn");
        }
        else if (position == 4){
            txtHinh.setText("Hải Phòng");
        }
        int s = txtHinh.getText().length();
        if (s <= 3){
            imgHinh.setImageResource(R.drawable.star);
        }
        else {
            imgHinh.setImageResource(R.drawable.world);
        }


        return row;
    }
}
