package com.example.aammu.moviedb;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    ArrayList<MovieDbInfo> list;
    RecyclerView recyclerView;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        list = (ArrayList<MovieDbInfo>) getIntent().getSerializableExtra("ArrayList");
        adapter = new MyAdapter(getApplicationContext(),list);
        recyclerView = findViewById(R.id.id_recycler_view);
        if(getApplication().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        else
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        recyclerView.setAdapter(adapter);
        for(int i=0;i<list.size();i++) {
            Log.i("Data is", list.get(i).getMovie_title());
            URL url = NetworkUtils.buildURL(list.get(i).getMovie_posterPath().toString(), false);
            Log.i("Poster URL is :", url.toString());
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settingsmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        String query=null;
        switch(itemId){
            case R.id.id_popular: query = "popular";
                break;
            case R.id.id_top_rated: query = "top_rated";
                break;
        }if(checkNetwork()){
            new MovieAsyncTask(this).execute(NetworkUtils.buildURL(query,true));

        }
        return true;
    }
    private boolean checkNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if(info == null){
            Toast.makeText(getApplicationContext(), "No internet, Please Check", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
