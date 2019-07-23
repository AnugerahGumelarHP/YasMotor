package com.battistradadeveloper.yasmotor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Pembelian extends AppCompatActivity {
    TextView submitdata;
    DatabaseHelper databaseHelper;

    EditText etname,etemail,ettype,etnumber,etsum;
    String name,email,type,number,sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembelian);
        etname = findViewById(R.id.username_buyer);
        etemail = findViewById(R.id.email_buyer);
        ettype = findViewById(R.id.tipe_kendaraan);
        etnumber = findViewById(R.id.nomor_kendaraan);
        etsum = findViewById(R.id.harga_kendaraan);

        submitdata = findViewById(R.id.txt_submit);
        databaseHelper = new DatabaseHelper(this);

        submitdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etname.getText().toString();
                email = etemail.getText().toString();
                type = ettype.getText().toString();
                number = etnumber.getText().toString();
                sum = etsum.getText().toString();
                //Toast.makeText(MainActivity.this,name, Toast.LENGTH_SHORT).show();
                if (name.isEmpty() && email.isEmpty()&& type.isEmpty()&& number.isEmpty() && sum.isEmpty()){
                    Toast.makeText(Pembelian.this, "please fill details", Toast.LENGTH_SHORT).show();
                }else {
                    databaseHelper.insertdata(name,email,type,number,sum);
                    etname.setText("");
                    etemail.setText("");
                    ettype.setText("");
                    etnumber.setText("");
                    etsum.setText("Rp. "+sum);
                    Intent intent = new Intent(Pembelian.this,RiwayatPembelian.class);
                    startActivity(intent);
                }
            }
        });
    }
}