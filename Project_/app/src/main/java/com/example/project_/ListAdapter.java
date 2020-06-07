package com.example.project_;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private Context context;
    private ArrayList<List> lists;

    public ListAdapter(Context mcontext, ArrayList<List> lists){
        context = mcontext;
        lists = lists;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list,parent, false);

        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        List listbaru = lists.get(position);
        String gambar = listbaru.getGambar();
        String nama = listbaru.getNama();
        String deskripsi = listbaru.getDeskripsi();

        holder.tvnamadata.setText(nama);
        holder.tvdeskripsidata.setText(deskripsi);
        Glide
                .with(context)
                .load(gambar)
                .centerCrop()
                .into(holder.imgdata);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgdata;
        public TextView tvnamadata;
        public TextView tvdeskripsidata;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgdata = itemView.findViewById(R.id.img_list);
            tvnamadata = itemView.findViewById(R.id.tv_nama);
            tvdeskripsidata = itemView.findViewById(R.id.tv_des);
        }
    }
}
