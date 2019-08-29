package com.testes.activity;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;

import com.testes.adapter.ImageAndTextAdapter;
import com.testes.android.R;

import java.util.ArrayList;

/**
 * Created by Utilizador on 04/01/2017.
 */

public class ImageAndTextActivity extends AppCompatActivity {

    private ListView mListView;
    private ImageAndTextAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mListView = (ListView) findViewById(R.id.listView);

        Resources res = getResources();
        TypedArray icons = res.obtainTypedArray(R.array.icons_array);

        String[] strings = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("f");
        arrayList.add("g");
        arrayList.add("h");
        arrayList.add("i");
        arrayList.add("J");
        arrayList.add("K");
        arrayList.add("l");
        arrayList.add("m");
        arrayList.add("n");
        arrayList.add("o");
        arrayList.add("p");
        arrayList.add("q");
        arrayList.add("r");
        arrayList.add("s");
        arrayList.add("t");
        arrayList.add("u");
        arrayList.add("v");
        arrayList.add("x");
        arrayList.add("y");
        arrayList.add("w");

        adapter = new ImageAndTextAdapter(this, R.layout.listview_item_layout, arrayList, icons);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                adapter.add("z");
            }

        }, 4000);


        mListView.setAdapter(adapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);


    }
}
