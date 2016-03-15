package com.testes.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.testes.android.R;
import com.testes.views.BrushView;

import java.util.ArrayList;

public class ListViewActivity extends Activity {

    private ListView mListView;
    private BaseAdapter adapter;
    private ArrayList<String> titlesArray;
    private LinearLayout home_linearLayout, search_layout;
    private Button search_btn;

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hide_layout);

        titlesArray = new ArrayList<String>();
        titlesArray.add("item 1!");
        titlesArray.add("item 2!");
        titlesArray.add("item 3!");
        titlesArray.add("item 4!");
        titlesArray.add("item 5!");

        search_btn = (Button) findViewById(R.id.search_btn);

        search_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                home_linearLayout.setVisibility(View.GONE);
                search_layout.setVisibility(LinearLayout.VISIBLE);
            }
        });

        mListView = (ListView) findViewById(R.id.bookListView);
        //		adapter = new NormalAdapter(this, titles);
        //		adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,titles);

        adapter = new MyAdapter();
        mListView.setAdapter(adapter);

        mListView.setSelection(2);

        mListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Log.i(getClass().getSimpleName(), "CLICK " + position);
            }
        });

        mListView.pointToPosition(200, 20);

        //mListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
//
//        mListView.setMultiChoiceModeListener(new MultiChoiceModeListener() {
//
////					    @Override
////					    public void deleteSelectedItems() {
////					        for (int i = 0; i < adapter.getCount(); i++) {
////					            if (mListView.isItemChecked(i)) {
////					                //Some actions
////					            }
////					        }
////					    }
//
//            @Override
//            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//                return false;
//            }
//
//            @Override
//            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//                return false;
//            }
//
//            @Override
//            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//                Log.i(getClass().getSimpleName(), "onActionItemClicked" + item.toString());
//                return false;
//            }
//
//            @Override
//            public void onDestroyActionMode(ActionMode mode) {
//
//
//            }
//
//            @Override
//            public void onItemCheckedStateChanged(ActionMode mode,
//                                                  int position, long id, boolean checked) {
//                Log.i(getClass().getSimpleName(), "Checked " + position);
//
//            }
//        });

        mListView.setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                Log.i(getClass().getSimpleName(), "LONG CLICK " + position);
                titlesArray.remove(position);
                ((MyAdapter) mListView.getAdapter()).notifyDataSetChanged();
                return true;
            }
        });

        home_linearLayout = (LinearLayout) findViewById(R.id.home_linear);

        BrushView view = new BrushView(this);
        home_linearLayout.addView(view.btnEraseAll, view.params);

        search_layout = (LinearLayout) findViewById(R.id.search_layout);

    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return titlesArray.size();
        }

        @Override
        public Object getItem(int position) {
            return titlesArray.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView;

            ViewHolder viewHolder = new ViewHolder();
            if (item == null) {

                item = getLayoutInflater().inflate(android.R.layout.simple_list_item_2, parent, false);

                item.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) item.getTag();
            }

            viewHolder.subTitleText = (TextView) item.findViewById(android.R.id.text2);
            viewHolder.titleText = (TextView) item.findViewById(android.R.id.text1);

            viewHolder.titleText.setText(titlesArray.get(position));

            return item;
        }

    }


    public void toggleMenu(View v) {
        Log.i("Toggle method", "Toggle Method");
        home_linearLayout.setVisibility(View.GONE); // not working

    }

    public class ViewHolder {
        private TextView titleText;
        private TextView subTitleText;
    }

}
