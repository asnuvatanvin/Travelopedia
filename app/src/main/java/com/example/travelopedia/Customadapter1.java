package com.example.travelopedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Customadapter1 extends BaseAdapter {

    int[] images;
    String[] names;
    String[] place;
    Context context;
    private LayoutInflater inflater;
    private int position;
    private View convertView;
    private ViewGroup parent;

    Customadapter1(Context context,String[] names,String[] place,int[] images){

        this.context=context;
        this.names=names;
        this.place=place;
        this.images=images;
    }
    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null ;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        this.position = position;
        this.convertView = convertView;
        this.parent = parent;

        if (convertView == null) {

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.cardviewforsites, parent, false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.picoftheplace);
        TextView textView = (TextView) convertView.findViewById(R.id.placename);
        TextView textView1 = (TextView) convertView.findViewById(R.id.lace);
        imageView.setImageResource(images[position]);
        textView.setText(names[position]);
        textView1.setText(place[position]);;
        return convertView;
    }
}
