package com.testes.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.testes.android.R;
import com.testes.data.Bean;

import java.util.ArrayList;
import java.util.List;

public class Adap extends BaseAdapter implements Filterable {
    public ArrayList<Bean> mData;
    public ArrayList<Bean> mFilteredData;
    Context ctx;

    public Adap(Context ctx, ArrayList<Bean> al_names) {
        mData = al_names;
        mFilteredData = al_names;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return mFilteredData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // LayoutInflater lf =;
        convertView = LayoutInflater.from(ctx).inflate(R.layout.pattern, parent, false);
        TextView tv = (TextView) convertView.findViewById(R.id.textView);
        TextView tv2 = (TextView) convertView.findViewById(R.id.textView2);
        tv.setText(mFilteredData.get(position).getName());
        tv2.setText("age:" + mFilteredData.get(position).getAge());

        return convertView;
    }

    @Override
    public Filter getFilter() {

  /*  if (mContactsFilter == null)
        mContactsFilter = new Filterer(mData);

    return mContactsFilter;
}*/
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults oReturn = new FilterResults();
                ArrayList<Bean> results = new ArrayList<Bean>();
                if (TextUtils.isEmpty(constraint))
                //   orig = al_namesfilter;
                {
                    oReturn.count = mData.size();
                    oReturn.values = mData;
                } else {
                    List<Bean> resultList = new ArrayList<>();
                    //    if (orig != null && orig.size() > 0) {

                    for (final Bean g : mData) {
                        if ((g.getName().toLowerCase()
                                .contains(constraint.toString())))
                            //   results.add(g);
                            resultList.add(g);
                    }
                    //  }
                    oReturn.count = resultList.size();
                    oReturn.values = resultList;
                }
                return oReturn;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
           /* al_namesfilter = (ArrayList<Beanclass>) results.values;
            notifyDataSetChanged();*/
                if (results.count == 0) {
                    notifyDataSetInvalidated();
                } else {
                    mFilteredData = (ArrayList<Bean>) results.values;
                    notifyDataSetChanged();
                }
            }
        };

    }
}