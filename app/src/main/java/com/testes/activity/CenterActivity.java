package com.testes.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.FragmentActivity;

import com.testes.android.R;

public class CenterActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_center);

        ListView listView = findViewById(R.id.parentListContainer);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.layout_center_item, R.id.titleView, new String[]{"Item 1", "Item 2"});
        listView.setAdapter(arrayAdapter);

    }

}
