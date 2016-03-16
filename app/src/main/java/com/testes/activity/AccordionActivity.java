package com.testes.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.testes.android.R;

/**
 * Created by Bold on 16/03/2016.
 */
public class AccordionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accordion_activity);

        Button btnProfile = (Button) findViewById(R.id.btnProfile);
        Button btnSettings = (Button) findViewById(R.id.btnSettings);
        Button btnPrivacy = (Button) findViewById(R.id.btnPrivacy);

        final View panelProfile = findViewById(R.id.panelProfile);
        panelProfile.setVisibility(View.GONE);

        final View panelSettings = findViewById(R.id.panelSettings);
        panelSettings.setVisibility(View.GONE);

        final View panelPrivacy = findViewById(R.id.panelPrivacy);
        panelPrivacy.setVisibility(View.GONE);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DO STUFF

                if (v.getTag() == null || v.getTag().equals("not_selected")) {
                    v.setBackgroundColor(Color.RED);
                    v.setTag("selected");
                    panelProfile.setVisibility(View.VISIBLE);

                    panelSettings.setVisibility(View.GONE);

                    panelPrivacy.setVisibility(View.GONE);
                } else {
                    v.setBackgroundResource(android.R.drawable.btn_default);
                    v.setTag("not_selected");
                    panelProfile.setVisibility(View.GONE);
                }


            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DO STUFF

                if (v.getTag() == null || v.getTag().equals("not_selected")) {
                    v.setBackgroundColor(Color.RED);
                    v.setTag("selected");
                    panelProfile.setVisibility(View.GONE);


                    panelSettings.setVisibility(View.VISIBLE);


                    panelPrivacy.setVisibility(View.GONE);
                } else {
                    v.setBackgroundResource(android.R.drawable.btn_default);
                    v.setTag("not_selected");
                    panelSettings.setVisibility(View.GONE);
                }


            }
        });

        btnPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DO STUFF

                if (v.getTag() == null || v.getTag().equals("not_selected")) {
                    v.setBackgroundColor(Color.RED);
                    v.setTag("selected");
                    panelProfile.setVisibility(View.GONE);


                    panelSettings.setVisibility(View.GONE);


                    panelPrivacy.setVisibility(View.VISIBLE);

                } else {
                    v.setBackgroundResource(android.R.drawable.btn_default);
                    v.setTag("not_selected");
                    panelPrivacy.setVisibility(View.GONE);
                }


            }
        });


    }
}
