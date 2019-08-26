package com.battistradadeveloper.yasmotor.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.battistradadeveloper.yasmotor.Adapter.RecycleAdapter;
import com.battistradadeveloper.yasmotor.Helper.DatabaseHelper;
import com.battistradadeveloper.yasmotor.Model.DataModel;
import com.battistradadeveloper.yasmotor.R;

import java.util.ArrayList;
import java.util.List;

public class RiwayatPembelian extends AppCompatActivity {
    Button btndeleteall, btnsendall;
    DatabaseHelper database;
    RecyclerView recyclerView;
    RecycleAdapter recycler;
    List<DataModel> datamodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_pembelian);
        datamodel =new ArrayList<DataModel>();
        recyclerView = findViewById(R.id.recycle);

        btndeleteall = findViewById(R.id.btn_deleteall);
        btndeleteall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.hapusSemuaDataPembelian();
                Toast.makeText(RiwayatPembelian.this, "Berhasil Menghapus Semua Data", Toast.LENGTH_SHORT).show();
                Intent delete = new Intent(RiwayatPembelian.this, MainActivity.class);
                startActivity(delete);
            }
        });

        btnsendall = findViewById(R.id.btn_sendall);
        btnsendall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"daus.moehammad@gmail.com"});
                intent.putExtra(Intent.EXTRA_CC, new String[] {"agum@battistradadeveloper.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "All Receipt Data");
                intent.putExtra(Intent.EXTRA_TEXT, "OMFG I just sent an email from my app!");
                try {
                    startActivity(Intent.createChooser(intent, "How to send mail?"));
                } catch (android.content.ActivityNotFoundException ex) {
                    //do something else
                }
            }
        });

        database = new DatabaseHelper(RiwayatPembelian.this);
        datamodel = database.getdata();

        recycler = new RecycleAdapter(datamodel);

        Log.i("HIteshdata",""+datamodel);
        RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(reLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recycler);

    }
}
