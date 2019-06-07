package com.cnblogs.sjjg.gaussianblur;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {


    private         SeekBar                     blurValue;
    private         ImageView                   image;
    private         RenderScriptGaussianBlur    blur;


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        int radius = seekBar.getProgress();
        if (radius < 1) {
            radius = 1;
        }
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.image);
        bitmap = blur.gaussianBlur(radius,bitmap);
        image.setImageBitmap(bitmap);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.imageView);
        blurValue = findViewById(R.id.blur_value);
        blurValue.setOnSeekBarChangeListener(this);
        blur = new RenderScriptGaussianBlur(getBaseContext());
    }
}
