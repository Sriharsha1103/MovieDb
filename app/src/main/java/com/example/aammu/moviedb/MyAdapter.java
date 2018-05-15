package com.example.aammu.moviedb;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context c;
    ArrayList<MovieDbInfo> list;

    public MyAdapter(Context c, ArrayList<MovieDbInfo> list) {
        this.c = c;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.row_recycle_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final URL url= NetworkUtils.buildURL(list.get(position).getMovie_posterPath().substring(1),false);
        Picasso.with(c).load(url.toString()).into(holder.image);
        MovieDbInfo info = list.get(position);
        final String title = info.getMovie_title();
        final String rating = info.getMovie_vote_average();
        final String date = info.getMovie_release_date();
        final String plot = info.getMovie_overview();
        final URL path = NetworkUtils.buildURL(list.get(position).getMovie_backdrop_path().substring(1),false);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(c,ContentActivity.class);
                i.putExtra("Title",title);
                i.putExtra("ImagePath",path.toString());
                i.putExtra("Plot",plot);
                i.putExtra("Date",date);
                i.putExtra("Rating",rating);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                c.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            image= itemView.findViewById(R.id.id_image_view);
        }
    }
}
