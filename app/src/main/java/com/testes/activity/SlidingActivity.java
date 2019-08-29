package com.testes.activity;

import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivityBase;
import com.testes.android.R;

public class SlidingActivity extends com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity implements SlidingActivityBase {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enormous_layout);
        setBehindContentView(R.layout.layout_bottom);
    }

}
