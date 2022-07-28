package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Activity5 extends AppCompatActivity {

    ImageView imageViewfotoMenu;
    TextView textViewNamaMenu, textViewhargaMenu, textViewJml, jmlangka;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        imageViewfotoMenu = findViewById(R.id.imageViewfotoMenu);
        textViewNamaMenu = findViewById(R.id.textViewNamaMenu);
        textViewhargaMenu = findViewById(R.id.textViewhargaMenu);
        textViewJml = findViewById(R.id.textViewinfoMenu);
        jmlangka = findViewById(R.id.JmlMenu);

        getExtra();

        Button btn = findViewById(R.id.order_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity5.this, Activity6.class);
                startActivity(intent);
            }
        });
    }

    private void getExtra(){
        if (getIntent().hasExtra("image_menu")&&
                getIntent().hasExtra("nama_menu")&&
                getIntent().hasExtra("harga_menu")&&
        getIntent().hasExtra("jumlah")){
                String gambar = getIntent().getStringExtra("image_menu");
                String namaMenu = getIntent().getStringExtra("nama_menu");
                String hargaMenu = getIntent().getStringExtra("harga_menu");
                String infoMenu = getIntent().getStringExtra("jumlah");

                setActivity(gambar, namaMenu, hargaMenu, infoMenu);

        }


    }
    private void setActivity(String gambar, String namaMenu,String hargaMenu, String infoMenu){

        Glide.with(this).asBitmap().load(gambar).into(imageViewfotoMenu);
        textViewNamaMenu.setText(namaMenu);
        textViewhargaMenu.setText(hargaMenu);
        textViewJml.setText(infoMenu);

    }


}