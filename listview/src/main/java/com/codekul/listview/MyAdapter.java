package com.codekul.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aniruddha on 29/5/17.
 */

public class MyAdapter extends BaseAdapter {

    private final Context context;
    private final List<MyItem> dataSet;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<MyItem> dataSet) {
        this.context = context;
        this.dataSet = dataSet;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position * 15;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View root = inflater.inflate(R.layout.my_view, parent, false);
        ((ImageView) root.findViewById(R.id.imgView)).setImageResource(dataSet.get(position).imgId);
        ((TextView) root.findViewById(R.id.txtName)).setText(dataSet.get(position).text);

        return root;
    }
}
