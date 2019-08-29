package com.testes.activity;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;

import com.testes.android.R;

public class CardActivity extends FragmentActivity {

    private CardView cardView;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_card);

        cardView = findViewById(R.id.card_view);

        cardView.setPreventCornerOverlap(false);
    }

}
