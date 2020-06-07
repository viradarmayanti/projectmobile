package com.example.project_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public static final String datanama = "datanama";
    public static final String datadeskripsi = "datadeskripsi";
    public static final String datasejarah = "datasejarah";
    public static final String dataciri = "dataciri";
    public static final String datagambar = "NULL";
    public TextView tvnamadata;
    public TextView tvdeskripsidata;
    public TextView tvsejarahdata;
    public TextView tvciridata;
    public ImageView imgdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvnamadata = findViewById(R.id.tv_nama);
        tvdeskripsidata = findViewById(R.id.tv_des);
        tvsejarahdata = findViewById(R.id.tv_sejarah);
        tvciridata = findViewById(R.id.tv_ciri);
        imgdata = findViewById(R.id.iv_list);

        String simpannama = getIntent().getStringExtra(datanama);
        String simpandeskripsi = getIntent().getStringExtra(datadeskripsi);
        String simpansejarah = getIntent().getStringExtra(datasejarah);
        String simpanciri = getIntent().getStringExtra(dataciri);
        String simpangambar = getIntent().getStringExtra(datagambar);

        tvnamadata.setText(simpannama);
        tvdeskripsidata.setText(simpandeskripsi);
        tvsejarahdata.setText(simpansejarah);
        tvciridata.setText(simpanciri);
        Glide
                .with(this)
                .load(simpangambar)
                .centerCrop()
                .into(imgdata);
    }
}
