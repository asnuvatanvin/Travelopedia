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

import org.w3c.dom.Text;

public class citydestiprofile extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private TextView textView;
    private String[] all;
    CardView hotel,sights,food,shop;
    String value;
    String lo,la;
    private String[] longitude;
    private String[] lattitude;
    private int[] pics={R.drawable.dhaka,R.drawable.chattogram,R.drawable.sylhet,R.drawable.khulna,R.drawable.barishal,R.drawable.rangpur,R.drawable.rajshahi,R.drawable.mymensingh};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citydestiprofile);

        all = getResources().getStringArray(R.array.allcities);
        longitude = getResources().getStringArray(R.array.longitude);
        lattitude = getResources().getStringArray(R.array.lattitude);
        imageView = (ImageView)findViewById(R.id.ima);
        textView = (TextView)findViewById(R.id.counn);
        hotel = (CardView)findViewById(R.id.hotel);
        sights = (CardView)findViewById(R.id.mounument);
        food = (CardView)findViewById(R.id.restaurants);
        shop = (CardView)findViewById(R.id.shopping);

        hotel.setOnClickListener(this);
        sights.setOnClickListener(this);
        food.setOnClickListener(this);
        shop.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){

            value=bundle.getString("place");
            setdetails(value);

        }
    }

    void setdetails(String value){
        int j = 0;
        for(int i=0;i<all.length;i++){
            if(all[i].equals(value)){
                j=i;
                lo=longitude[i];
                la=lattitude[i];
                break;
            }
        }
        imageView.setImageResource(pics[j]);
        textView.setText(value);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.hotel){
            String geo="";
            geo="geo:"+lo+","+la+"?z=10&q="+"hotels";
            Uri gmmIntentUri = Uri.parse(geo);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);

        }
        else if(v.getId()==R.id.restaurants){
            String geo="";
            geo="geo:"+lo+","+la+"?z=10&q="+"restaurants";
            Uri gmmIntentUri = Uri.parse(geo);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        else if(v.getId() == R.id.shopping){
            String geo="";
            geo="geo:"+lo+","+la+"?z=10&q="+"shopping";
            Uri gmmIntentUri = Uri.parse(geo);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        else{
            String geo="";
            geo="geo:"+lo+","+la+"?z=10&q="+"attractions";
            Uri gmmIntentUri = Uri.parse(geo);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);

        }

    }
}
