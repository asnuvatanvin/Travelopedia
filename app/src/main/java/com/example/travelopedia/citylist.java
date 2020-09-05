package com.example.travelopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class citylist extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citylist);
        listView =(ListView) findViewById(R.id.citylist);
        Bundle bundle = this.getIntent().getExtras();
        final String[] cityarray = bundle.getStringArray("city");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(citylist.this,R.layout.citylistview,R.id.cityname,cityarray);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = cityarray[position];
                Intent intent = new Intent(citylist.this,citydestiprofile.class);
                intent.putExtra("place",value);
                startActivity(intent);
            }
        });
    }
}
