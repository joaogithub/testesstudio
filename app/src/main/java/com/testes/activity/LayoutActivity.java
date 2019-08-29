package com.testes.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.testes.android.R;

public class LayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.include_layout);

        View view = getLayoutInflater().inflate(R.layout.inflate_layout, null);
        if (view != null) {
            LinearLayout mContentContainer = (LinearLayout) findViewById(R.id.content);
            mContentContainer.addView(view);


        }

    }

}
