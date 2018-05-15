package com.example.aammu.moviedb;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    //public static String URL = "https://api.themoviedb.org/3/movie/popular?api_key=d696f7a5f93540b0dac2ed52b5b7ee93";
    public static String GET_URL = "https://api.themoviedb.org/3";
    public static String NAME = "movie";
    public static String API_KEY = "api_key";
    public static String IMAGE_URL = "http://image.tmdb.org/t/p/w300";
    public static URL url=null;
    public static URL buildURL(String query,Boolean value){
        Uri buildUri;
        if(value) {
            buildUri = Uri.parse(GET_URL).buildUpon()
                    .appendPath(NAME)
                    .appendPath(query)
                    .appendQueryParameter(API_KEY, "d696f7a5f93540b0dac2ed52b5b7ee93").build();
        }
        else{
            buildUri = Uri.parse(IMAGE_URL).buildUpon()
                    .appendPath(query).build();
        }
        try {
            url = new URL(buildUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
    public static String getResponseFromHttpUrl(URL url)
        throws IOException{
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try{
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();
            if(hasInput)
                    return scanner.next();
            else
                    return null;
        }
        finally {
            urlConnection.disconnect();
        }

    }
}
