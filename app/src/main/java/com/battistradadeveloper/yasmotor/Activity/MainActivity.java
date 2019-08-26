package com.battistradadeveloper.yasmotor.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.battistradadeveloper.yasmotor.R;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Button btnPembelian, btnRiwayat;
    private SliderLayout sliderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderLayout = findViewById(R.id.slider);

        //Load image dari URL
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Yas Motor", "https://www.google.com/");
        url_maps.put("Tipe Motor", "https://www.google.com/");

        // Load Image Dari res/drawable
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Yas Motor",R.drawable.yasmotortagline);
        file_maps.put("Tipe Motor",R.drawable.tipemotor);
        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);

        btnPembelian = findViewById(R.id.btn_input);
        btnRiwayat = findViewById(R.id.btn_riwayat);

        btnPembelian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pembelian = new Intent(MainActivity.this, Pembelian.class);
                startActivity(pembelian);
            }
        });

        //Masih perlu pengembangan detail
        btnRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent riwayat = new Intent(MainActivity.this, RiwayatPembelian.class);
                startActivity(riwayat);
            }
        });
    }
}
