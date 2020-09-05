package com.example.travelopedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class welcomepage extends AppCompatActivity implements View.OnClickListener {

    private CardView destination,profile,albums,explore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);
        destination = findViewById(R.id.dest);
        profile = findViewById(R.id.pro);
        albums = findViewById(R.id.albums);
        explore = findViewById(R.id.exploree);

        destination.setOnClickListener(this);
        profile.setOnClickListener(this);
        albums.setOnClickListener(this);
        explore.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.dest){
            Intent intent = new Intent(welcomepage.this,Destinations.class);
            startActivity(intent);

        }
        else if(v.getId()==R.id.pro){

        }
        else if(v.getId()==R.id.albums){

        }
        else{
            Intent intent = new Intent(welcomepage.this,MyLocationDemoActivity.class);
            startActivity(intent);
        }


    }
}
