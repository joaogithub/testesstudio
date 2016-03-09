package com.testes.adapter;

/**
 * Created by Bold on 08/03/2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.testes.android.R;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * IRS by Carbon by BOLD
 * Created in 16/10/15 by the following authors:
 * <p/>
 * João Amaro - {joaoamaro@carbonbybold.com}
 */
public class AdapterSwipe extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<String> mIncludedCategories;

    public AdapterSwipe(Context context) {

        mContext = context;
        mIncludedCategories = new ArrayList<String>( Arrays.asList(mContext.getResources().getStringArray(R.array.included)));

    }

    public ArrayList<String> getItems(){
       return mIncludedCategories;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        IncludedViewHolder includedViewHolder = (IncludedViewHolder) holder;

        // Set title
        includedViewHolder.mIncludedText.setText(mIncludedCategories.get(position));

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new IncludedViewHolder(view);
    }

    @Override
    public int getItemCount() {

        if(mIncludedCategories != null) {
            return mIncludedCategories.size();
        }
        return 0;
    }

    public static class IncludedViewHolder extends RecyclerView.ViewHolder {

        private TextView mIncludedText;
        private LinearLayout mContainer;

        public IncludedViewHolder(View view) {
            super(view);
            mIncludedText = (TextView)view.findViewById(android.R.id.text1);
        }
    }
}
