package com.testes.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.testes.adapter.AdapterSwipe;
import com.testes.android.R;

/**
 * Created by Bold on 08/03/2016.
 */
public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycler_activity);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(new AdapterSwipe(this));

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Log.i(getClass().getSimpleName(), "onmove " + target);
                System.out.println("move");

                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                Log.i(getClass().getSimpleName(), "swiped " + swipeDir);
                System.out.println("swipe " + swipeDir);
                showTermsPopup(viewHolder.getAdapterPosition());
            }

            @Override
            public float getSwipeEscapeVelocity(float defaultValue) {

                return super.getSwipeEscapeVelocity(defaultValue * 20);
            }

            @Override
            public float getSwipeVelocityThreshold(float defaultValue) {
                return super.getSwipeVelocityThreshold(defaultValue * 10);
            }

            @Override
            public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {

                return super.getSwipeThreshold(viewHolder);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);

        itemTouchHelper.attachToRecyclerView(recyclerView);

    }


    private void showTermsPopup(final int position) {

        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setMessage(getString(R.string.remove))
                .setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        ((AdapterSwipe) recyclerView.getAdapter()).getItems().remove(position);
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }
                });

        dialog.show();

    }
}
