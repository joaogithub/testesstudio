package com.testes.activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.testes.android.R;

public class LottieActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lottie_activity);

        ImageView gifImageView = findViewById(R.id.gifImv);

        Glide.with(this)
                .load(R.drawable.aviaogif)
                .asGif()
                .placeholder(R.drawable.face)
                .into(gifImageView);
    }
}
