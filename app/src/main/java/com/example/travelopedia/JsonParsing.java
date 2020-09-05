package com.example.travelopedia;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonParsing extends AsyncTask <Void,Void,Void>{

    String line="",data="",singleparsed="",dataparsed="";


    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("https://api.myjson.com/bins/bp3zk");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while(line!=null){
                line = bufferedReader.readLine();
                data = data+line;
            }

            JSONObject obj=new JSONObject(data);
            JSONArray jk = obj.getJSONArray("countries");
            for(int i=0;i<jk.length();i++){

                JSONObject jo= (JSONObject)jk.get(i);
                singleparsed = (String) jo.get("Description");
                dataparsed = dataparsed+singleparsed+"\n";

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Void aVoid){

        destview.textView.setText(dataparsed);
        super.onPostExecute(aVoid);
    }
}
