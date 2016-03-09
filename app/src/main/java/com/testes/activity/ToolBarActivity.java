package com.testes.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.testes.adapter.Adap;
import com.testes.android.R;
import com.testes.data.Bean;

import java.util.ArrayList;

public class ToolBarActivity extends AppCompatActivity {
    ListView lv_listname;
    ArrayList<Bean> al_names, al_names2;
    ArrayList<String> altype;
    Adap ad_names;
    ArrayAdapter<String> ad;
    //MaterialSearchView searchview;
    Toolbar toolbar;
    android.widget.Filter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        lv_listname = (ListView) findViewById(R.id.listView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //  toolbar.setNavigationIcon(R.drawable.back_arrow_white);

        //searchview = (MaterialSearchView) findViewById(R.id.searchview);

        al_names = new ArrayList<>();
   /* altype = new ArrayList<>();

    altype.add("Rushi");
    altype.add("ayyappa");
    altype.add("kiran");
    altype.add("priya");
    altype.add("swathi");
    altype.add("pen");
    altype.add("bat");
    altype.add("cat");
    ad = new ArrayAdapter<String>   
       (MainActivity.this,android.R.layout.simple_list_item_1,altype);
    lv_listname.setAdapter(ad);
    filter=ad.getFilter();*/
        //         ad.notifyDataSetChanged();
        al_names.add(new Bean("Rushi", 22));
        al_names.add(new Bean("Swathi", 22));
        al_names.add(new Bean("Priya", 22));
        al_names.add(new Bean("Kiran", 22));
        al_names.add(new Bean("Laskshmi", 22));
        al_names.add(new Bean("Hammad", 22));
        al_names.add(new Bean("Anil", 22));
        al_names.add(new Bean("Anand", 22));
        al_names2 = al_names;
        ad_names = new Adap(this, al_names);
        lv_listname.setAdapter(ad_names);

        lv_listname.setTextFilterEnabled(false);
        //   filter = ad_names.getFilter();
        //ad_names.notifyDataSetChanged();
    /*setupSearchView();*/

//        searchview.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
//            @Override
//            public void onSearchViewShown() {
//                searchview.setVisibility(View.VISIBLE);
//                Toast.makeText(getApplicationContext(), "opened ", Toast.LENGTH_LONG).show();
//                toolbar.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onSearchViewClosed() {
//                //  lv_listname.clearTextFilter();
//
//                Toast.makeText(getApplicationContext(), "closed ", Toast.LENGTH_LONG).show();
//                toolbar.setVisibility(View.VISIBLE);
//
//            }
//        });
//
//
//        searchview.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if (TextUtils.isEmpty(newText)) {
//                    lv_listname.clearTextFilter();
//                } else {
//                    // lv_listname.setFilterText(newText);
//                    ad_names.getFilter().filter(newText);
//                    //filter.filter(newText);
//                }
//                return true;
//            }
//        });
//        lv_listname.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), "you clicked on " + al_names.get(position), Toast.LENGTH_LONG).show();
//            }
//        });
//        // searchview.setSubmitButtonEnabled(true);
//        searchview.setHint("Search Containers");
    }

    private void setupSearchView() {
        //  searchview.setIconifiedByDefault(false);

        //   searchview.seti
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        //MenuItem item = menu.findItem(R.id.searchicon);
        //searchview.setMenuItem(item);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//        if (id == R.id.searchicon) {
//            searchview.setVisibility(View.VISIBLE);
//
//        }


        return super.onOptionsItemSelected(item);
    }


}