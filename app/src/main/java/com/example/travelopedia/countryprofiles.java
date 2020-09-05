package com.example.travelopedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.travelopedia.R.id.ima;
import static com.example.travelopedia.R.id.text;

public class countryprofiles extends AppCompatActivity implements View.OnClickListener {

    CardView about, map, weather, city, sites;
    private ImageView imageView;
    private TextView textView;
    private Intent intent;
    public destview dest;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countryprofiles);
        about = (CardView) findViewById(R.id.about);
        map = (CardView) findViewById(R.id.map);
        weather = (CardView) findViewById(R.id.weather);
        city = (CardView) findViewById(R.id.city);
        sites = (CardView) findViewById(R.id.touristsites);
        imageView = (ImageView) findViewById(R.id.ima);
        textView = (TextView) findViewById(R.id.counn);


        about.setOnClickListener(this);
        map.setOnClickListener(this);
        weather.setOnClickListener(this);
        city.setOnClickListener(this);
        sites.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            value = bundle.getString("name");
            showdetails(value);
        }
    }

    void showdetails(String value) {
        if (value.equals("Bangladesh")) {

            imageView.setImageResource(R.drawable.bangladesh);
            textView.setText("Bangladesh");
            //destview.imageView.setImageResource(R.drawable.bangladesh);
        }
        if (value.equals("Bhutan")) {

            imageView.setImageResource(R.drawable.bhutan);
            textView.setText("Bhutan");
            //destview.imageView.setImageResource(R.drawable.bhutan);
        }
        if (value.equals("England")) {

            imageView.setImageResource(R.drawable.england);
            textView.setText("England");
            //destview.imageView.setImageResource(R.drawable.england);
        }
        if (value.equals("France")) {

            imageView.setImageResource(R.drawable.france);
            textView.setText("France");
            //destview.imageView.setImageResource(R.drawable.france);
        }
        if (value.equals("Nepal")) {

            imageView.setImageResource(R.drawable.nepal);
            textView.setText("Nepal");
            //destview.imageView.setImageResource(R.drawable.nepal);
        }
        if (value.equals("India")) {

            imageView.setImageResource(R.drawable.india);
            textView.setText("India");
            destview.imageView.setImageResource(R.drawable.india);
        }
        if (value.equals("Indonesia")) {

            imageView.setImageResource(R.drawable.indonesia);
            textView.setText("Indonesia");
            //destview.imageView.setImageResource(R.drawable.indonesia);
        }
        if (value.equals("Malaysia")) {

            imageView.setImageResource(R.drawable.malaysia);
            textView.setText("Malaysia");
            //destview.imageView.setImageResource(R.drawable.malaysia);
        }
        if (value.equals("Spain")) {

            imageView.setImageResource(R.drawable.spain);
            textView.setText("Spain");
            //destview.imageView.setImageResource(R.drawable.spain);
        }
        if (value.equals("Sri Lanka")) {

            imageView.setImageResource(R.drawable.cou);
            textView.setText("Sri Lanka");
            //destview.imageView.setImageResource(R.drawable.cou);
        }
        if (value.equals("Thailand")) {

            imageView.setImageResource(R.drawable.thailand);
            textView.setText("Thailand");
            //destview.imageView.setImageResource(R.drawable.thailand);
        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.city) {

            if (value.equals("Bangladesh")) {
                String[] array = getResources().getStringArray(R.array.Bangladeshcity);
                Bundle b = new Bundle();
                b.putStringArray("city", array);
                Intent intent = new Intent(countryprofiles.this, citylist.class);
                intent.putExtras(b);
                startActivity(intent);
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
                String[] array = getResources().getStringArray(R.array.indiacities);
                Bundle b = new Bundle();
                b.putStringArray("city", array);
                Intent intent = new Intent(countryprofiles.this, citylist.class);
                intent.putExtras(b);
                startActivity(intent);

            }
            if (value.equals("Indonesia")) {


            }
            if (value.equals("Malaysia")) {
                String[] array = getResources().getStringArray(R.array.malaysiacities);
                Bundle b = new Bundle();
                b.putStringArray("city", array);
                Intent intent = new Intent(countryprofiles.this, citylist.class);
                intent.putExtras(b);
                startActivity(intent);

            }
            if (value.equals("Spain")) {


            }
            if (value.equals("Sri Lanka")) {
                String[] array = getResources().getStringArray(R.array.SriLankacities);
                Bundle b = new Bundle();
                b.putStringArray("city", array);
                Intent intent = new Intent(countryprofiles.this, citylist.class);
                intent.putExtras(b);
                startActivity(intent);
            }
            if (value.equals("Thailand")) {


            }
        } else if (v.getId() == R.id.map) {

            if (value.equals("Bangladesh")) {
                Uri gmmIntentUri = Uri.parse("geo:23.6850,90.3563");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
            if (value.equals("Bhutan")) {
                Uri gmmIntentUri = Uri.parse("geo:27.5142,90.4336");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
            if (value.equals("England")) {

                Uri gmmIntentUri = Uri.parse("geo:52.3555,1.1743");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
            if (value.equals("France")) {

                Uri gmmIntentUri = Uri.parse("geo:46.2276,2.2137");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
            if (value.equals("Nepal")) {

                Uri gmmIntentUri = Uri.parse("geo:28.3949,84.1240");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
            if (value.equals("India")) {

                Uri gmmIntentUri = Uri.parse("geo:20.5937,78.9629");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
            if (value.equals("Indonesia")) {
                Uri gmmIntentUri = Uri.parse("geo:0.7893,113.9213");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
            if (value.equals("Malaysia")) {

                Uri gmmIntentUri = Uri.parse("geo:4.2105,101.9758");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
            if (value.equals("Spain")) {
                Uri gmmIntentUri = Uri.parse("geo:40.4637,3.7492");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }

            if (value.equals("Sri Lanka")) {
                Uri gmmIntentUri = Uri.parse("geo:7.8731,80.7718");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
            if (value.equals("Thailand")) {

                Uri gmmIntentUri = Uri.parse("geo:15.8700,100.9925");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }

        } else if (v.getId() == R.id.touristsites) {

            Intent i = new Intent(countryprofiles.this, touristsites.class);
            i.putExtra("sites", value);
            startActivity(i);
        }

        else if(v.getId() == R.id.about){

            Intent intent = new Intent(countryprofiles.this,destview.class);
            intent.putExtra("country",value);
            startActivity(intent);
        }
    }
}
