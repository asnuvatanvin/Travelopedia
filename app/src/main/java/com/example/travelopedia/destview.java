package com.example.travelopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class destview extends AppCompatActivity {

    public static TextView textView;
    private TextView t1;
    public static ImageView imageView;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destview);

        imageView = (ImageView)findViewById(R.id.destpic);
        textView = (TextView)findViewById(R.id.descriptiontext);
        t1=(TextView)findViewById(R.id.destname);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name = bundle.getString("country");
        }
        if(name.equals("Bangladesh")){

        }
        t1.setText(name);
        JsonParsing jsonParsing = new JsonParsing();
        jsonParsing.execute();
    }
}
