package com.example.travelopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

public class Destinations extends AppCompatActivity {
    private String[] countryNames;
    private int[] images = {R.drawable.bangladesh, R.drawable.bhutan, R.drawable.england, R.drawable.france, R.drawable.india, R.drawable.indonesia, R.drawable.malaysia, R.drawable.nepal, R.drawable.spain, R.drawable.cou, R.drawable.thailand};
    private ListView listView;
    private SearchView searchView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destinations);

        countryNames = getResources().getStringArray(R.array.country_names);
        listView = (ListView) findViewById(R.id.suggetionview);
        final CustomAdapter adapter = new CustomAdapter(this, countryNames, images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value=countryNames[position];
                intent = new Intent(Destinations.this,countryprofiles.class);
                intent.putExtra("name",value);
                startActivity(intent);

            }
        });
        searchView = (SearchView)findViewById(R.id.searchview1);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query){
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });

    }
}