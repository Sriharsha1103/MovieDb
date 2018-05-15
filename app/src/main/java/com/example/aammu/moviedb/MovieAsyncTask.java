package com.example.aammu.moviedb;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MovieAsyncTask extends android.os.AsyncTask<URL,Void,String> {
    Activity c;
    private ProgressDialog progressDialog=null;

    public MovieAsyncTask(Activity c) {
        this.c = c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(c);
        progressDialog.setMessage("Loading Data........");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        progressDialog.setCancelable(false);

    }

    @Override
    protected String doInBackground(URL... urls) {
        String result="";
        try {
            result = NetworkUtils.getResponseFromHttpUrl(urls[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(progressDialog!=null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
        ArrayList<MovieDbInfo> list = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject o = jsonArray.getJSONObject(i);
                Log.i("Result Object",o.toString());
                list.add(new MovieDbInfo(o.getInt("id"),
                        o.getInt("vote_count"),
                        o.getString("video"),
                        o.getString("vote_average"),
                        o.getString("title"),
                        o.getString("popularity"),
                        o.getString("poster_path"),
                        o.getString("original_language"),
                        o.getString("original_title"),
                        o.getString("backdrop_path"),
                        o.getString("adult"),
                        o.getString("overview"),
                        o.getString("release_date")));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Intent i = new Intent(c,DisplayActivity.class);
        i.putExtra("ArrayList",list);
        c.startActivity(i);
        c.finish();
    }
}