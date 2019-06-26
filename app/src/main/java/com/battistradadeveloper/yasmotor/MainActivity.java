package com.battistradadeveloper.yasmotor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    Button btnPembelian, btnRiwayat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPembelian = findViewById(R.id.btn_input);
        btnRiwayat = findViewById(R.id.btn_riwayat);

        btnPembelian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pembelian = new Intent(MainActivity.this,Pembelian.class);
                startActivity(pembelian);
            }
        });

        //Masih perlu pengembangan detail
        btnRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent riwayat = new Intent(MainActivity.this,RiwayatPembelian.class);
                startActivity(riwayat);
            }
        });
    }
}
