package com.example.uts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Recycleview_Adapter extends RecyclerView.Adapter<Recycleview_Adapter.viewHolder>{

    private ArrayList<String> gambar = new ArrayList<>();
    private ArrayList<String> namaMenu = new ArrayList<>();
    private ArrayList<String> hargaMenu = new ArrayList<>();
    private  ArrayList<String> infoMenu= new ArrayList<>();
    private ArrayList <String> jml = new ArrayList<>();
    private Context ct;

    public Recycleview_Adapter(ArrayList<String> gambar, ArrayList<String> namaMenu, ArrayList<String> hargaMenu, ArrayList<String> infoMenu, ArrayList<String> jml,Context ct) {
        this.gambar = gambar;
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
        this.infoMenu = infoMenu;
        this.jml = jml;
        this.ct = ct;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adapter,parent,false);
        viewHolder holder = new viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Glide.with(ct).asBitmap().load(gambar.get(position)).into(holder.imageViewMenu);

        holder.nama.setText(namaMenu.get(position));
        holder.harga.setText(hargaMenu.get(position));

        holder.conLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ct, Activity5.class);
                intent.putExtra("image_menu", gambar.get(position));
                intent.putExtra("nama_menu", namaMenu.get(position));
                intent.putExtra("harga_menu", hargaMenu.get(position));
                intent.putExtra("jumlah", infoMenu.get(position));


                ct.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return namaMenu.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

       ImageView imageViewMenu;
       TextView nama;
       TextView harga;
       ConstraintLayout conLay;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewMenu = itemView.findViewById(R.id.imageViewMenu);
            nama = itemView.findViewById(R.id.textViewNama);
            harga = itemView.findViewById(R.id.textViewHarga);
            conLay = itemView.findViewById(R.id.conLay);

        }
    }
}
