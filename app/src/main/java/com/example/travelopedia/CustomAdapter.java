package com.example.travelopedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter implements Filterable {

    int[] images;
    String[] countrynames;
    Context context;
    private LayoutInflater inflater;
    public static ArrayList<String> temporarylist;

    CustomAdapter(Context context, String[] c, int[] f) {

        this.context = context;
        countrynames = c;
        images = f;

    }

    public int getCount() {
        return countrynames.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.samplelayout1, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.countrystart);
        TextView textView = (TextView) convertView.findViewById(R.id.countryimagename);
        imageView.setImageResource(images[position]);
        textView.setText(countrynames[position]);
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                temporarylist = (ArrayList<String>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                ArrayList<String> FilteredList = new ArrayList<String>();
                if (constraint == null || constraint.length() == 0) {
                    // No filter implemented we return all the list
                    for (int i = 0; i < countrynames.length; i++) {
                        String data = countrynames[i];
                        FilteredList.add(data);
                    }
                    results.values = FilteredList;
                    results.count = FilteredList.size();

                } else {
                    for (int i = 0; i < countrynames.length; i++) {
                        String data = countrynames[i];
                        if (data.toLowerCase().contains(constraint.toString())) {
                            FilteredList.add(data);
                        }
                    }
                    results.values = FilteredList;
                    results.count = FilteredList.size();
                }
                return results;
            }
        };
        return filter;
    }
}
