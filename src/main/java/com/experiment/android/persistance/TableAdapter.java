package com.experiment.android.persistance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TableAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    String[] sbase;
    String[] srange;
    String[] sproduct;

    public TableAdapter(Context c, String[] base, String[] range,  String[] product){

        sbase = base;
        srange = range;
        sproduct = product;

        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sbase.length;
    }

    @Override
    public Object getItem(int position) {
        return sbase[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.table_values,null);
        TextView baseTextView = (TextView) view.findViewById(R.id.baseTextView);
        TextView rangeTextView = (TextView) view.findViewById(R.id.rangeTextView);
        TextView productTextView = (TextView) view.findViewById(R.id.productTextView);

        String ssbase = sbase[position];
        String ssrange = srange[position];
        String ssproduct = sproduct[position];

        baseTextView.setText(ssbase);
        rangeTextView.setText(ssrange);
        productTextView.setText(ssproduct);

        return view;
    }
}
