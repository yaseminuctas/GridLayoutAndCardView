package com.example.test11;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        setContentView(R.layout.activity_main);


        String jsonToParse = loadJSONFromAsset(); //jsonımı parse ediyorum
        Gson gson = new Gson();
        YemekList yemekList = gson.fromJson(jsonToParse, YemekList.class);// Oluşturduğum gson objesini YemekList classıma çeviriyorum.
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(yemekList.getFoods(), this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new GridLayoutManager(this,2));
        recyclerView.setAdapter(myAdapter);
    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }



    public void onImageClicked(Yemek yemek) {

    }

}