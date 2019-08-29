package com.testes.activity;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.testes.android.R;

import java.util.Calendar;

public class SplashActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(getClass().getSimpleName(), "onCreate()");
        setContentView(R.layout.blow_layout);
        final Intent myAct = new Intent(this, FirstActivity.class);
        //BLOCKS UI THREAD
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		Log.i("SplashActivity","sleeped");
//		startActivity(myAct);
//		finish();

//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//                Log.i(TAG, "inir");
//            }
//        });


        ImageView imageView = new ImageView(this);
        imageView.setId(132131311);
        imageView.setBackgroundResource(R.drawable.ball);
        imageView.setImageResource(R.drawable.zoom_in);
        imageView.setScaleType(ScaleType.CENTER);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;

        addContentView(imageView, params);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 4);
        cal.set(Calendar.MINUTE, 23);

        int i = 2;
        int c = i + 3;
        i = 4;
        Log.i("Splash reference:", "" + c);

        new

                Thread() {
                    public void run() {
                        try {
                            Thread.sleep(2000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.i(getClass().getSimpleName(), "sleeped");
                        startActivity(myAct);
                        finish();
                    }

                }.

                start();

    }
}