package com.example.aammu.moviedb;

import android.media.Image;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ContentActivity extends AppCompatActivity {
    TextView plot,rating,date;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Bundle b = getIntent().getExtras();
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getIntent().getStringExtra("Title"));
        image = (ImageView) findViewById(R.id.id_image);
        plot = (TextView) findViewById(R.id.id_plot_movie);
        rating = (TextView) findViewById(R.id.id_rating_movie);
        date = (TextView) findViewById(R.id.id_movie_date);
        plot.setText("Plot \n"+b.getString("Plot"));
        rating.setText("Rating : "+b.getString("Rating"));
        date.setText("Release Date: "+b.getString("Date"));
        Log.i("Imagepath",b.getString("ImagePath"));
        Picasso.with(this).load(b.getString("ImagePath")).into(image);
        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.expandedappbar);


    }
}
