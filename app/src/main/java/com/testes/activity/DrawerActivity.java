package com.testes.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.testes.android.R;

public class DrawerActivity extends AppCompatActivity {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_third_drawer_activity);

        drawer = findViewById(R.id.drawer_layout);

        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        getSupportActionBar().setHomeButtonEnabled(true);

        load();

    }

    public void load() {

        //		RelativeLayout usersLinear = (RelativeLayout) findViewById(R.id.loading_layout);
        LinearLayout usersLinear = (LinearLayout) findViewById(R.id.linLayout);
        RelativeLayout userRelative = new RelativeLayout(this);
        userRelative.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        userRelative.setPadding(0, 5, 5, 0);
        userRelative.setBackgroundResource(R.drawable.border);
        //		usersLinear.setBackgroundResource(R.drawable.border);
        usersLinear.addView(userRelative);

        //NavigationMenuItemView view;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//			if(!drawer.isDrawerOpen(Gravity.LEFT))
//				drawer.openDrawer(Gravity.LEFT);
//			else
//				drawer.closeDrawer(Gravity.LEFT);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
