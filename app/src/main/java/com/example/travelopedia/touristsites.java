package com.example.travelopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class touristsites extends AppCompatActivity {

    private String[] touristsites;
    private String[] place;
    private int[] bdpics = {R.drawable.somapurivihara,R.drawable.ahsan,R.drawable.lalbag,R.drawable.nmemorial,R.drawable.nafa,R.drawable.shaheed,R.drawable.ratargul,R.drawable.sundarbans,R.drawable.sajek,R.drawable.martins,R.drawable.srimangal,R.drawable.tanguahaor,R.drawable.kantajirmandir,R.drawable.coxsbazar,R.drawable.guliakhali};
    private TextView t1,t2;
    private ImageView imageView;
    private ListView listView;
    private String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touristsites);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            value=bundle.getString("sites");
        }

        t1 = (TextView)findViewById(R.id.placename);
        t2 = (TextView)findViewById(R.id.lace);
        imageView = (ImageView)findViewById(R.id.picoftheplace);
        listView = (ListView)findViewById(R.id.siteslistview);

        if(value.equals("Bangladesh")){
            touristsites = getResources().getStringArray(R.array.touristsitesBangladesh);
            place = getResources().getStringArray(R.array.touristsitesbd);
            Customadapter1 adapter1 = new Customadapter1(this,touristsites,place,bdpics);
            listView.setAdapter(adapter1);
        }
        if (value.equals("Bhutan")) {

        }
        if (value.equals("England")) {

        }
        if (value.equals("France")) {

        }
        if (value.equals("Nepal")) {

        }
        if (value.equals("India")) {

        }
        if (value.equals("Indonesia")) {

        }
        if (value.equals("Malaysia")) {

        }
        if (value.equals("Spain")) {

        }
        if (value.equals("Sri Lanka")) {

        }
        if (value.equals("Thailand")) {

        }

    }
}
