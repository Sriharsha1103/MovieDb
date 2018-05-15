package com.example.aammu.moviedb;

import java.io.Serializable;

public class MovieDbInfo implements Serializable{
    private int movie_id;
    private int movie_vote;
    private String movie_trailer_video;
    private String movie_vote_average;
    private String movie_title;
    private String movie_popularity;
    private String movie_posterPath;
    private String movie_original_language;
    private String movie_original_title;
    private String movie_backdrop_path;
    private String movie_adult;
    private String movie_overview;
    private String movie_release_date;

    public MovieDbInfo(int movie_id, int movie_vote, String movie_trailer_video, String movie_vote_average, String movie_title, String movie_popularity, String movie_posterPath, String movie_original_language, String movie_original_title, String movie_backdrop_path, String movie_adult, String movie_overview, String movie_release_date) {
        this.movie_id = movie_id;
        this.movie_vote = movie_vote;
        this.movie_trailer_video = movie_trailer_video;
        this.movie_vote_average = movie_vote_average;
        this.movie_title = movie_title;
        this.movie_popularity = movie_popularity;
        this.movie_posterPath = movie_posterPath;
        this.movie_original_language = movie_original_language;
        this.movie_original_title = movie_original_title;
        this.movie_backdrop_path = movie_backdrop_path;
        this.movie_adult = movie_adult;
        this.movie_overview = movie_overview;
        this.movie_release_date = movie_release_date;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getMovie_vote() {
        return movie_vote;
    }

    public void setMovie_vote(int movie_vote) {
        this.movie_vote = movie_vote;
    }

    public String getMovie_trailer_video() {
        return movie_trailer_video;
    }

    public void setMovie_trailer_video(String movie_trailer_video) {
        this.movie_trailer_video = movie_trailer_video;
    }

    public String getMovie_vote_average() {
        return movie_vote_average;
    }

    public void setMovie_vote_average(String movie_vote_average) {
        this.movie_vote_average = movie_vote_average;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_popularity() {
        return movie_popularity;
    }

    public void setMovie_popularity(String movie_popularity) {
        this.movie_popularity = movie_popularity;
    }

    public String getMovie_posterPath() {
        return movie_posterPath;
    }

    public void setMovie_posterPath(String movie_posterPath) {
        this.movie_posterPath = movie_posterPath;
    }

    public String getMovie_original_language() {
        return movie_original_language;
    }

    public void setMovie_original_language(String movie_original_language) {
        this.movie_original_language = movie_original_language;
    }

    public String getMovie_original_title() {
        return movie_original_title;
    }

    public void setMovie_original_title(String movie_original_title) {
        this.movie_original_title = movie_original_title;
    }

    public String getMovie_backdrop_path() {
        return movie_backdrop_path;
    }

    public void setMovie_backdrop_path(String movie_backdrop_path) {
        this.movie_backdrop_path = movie_backdrop_path;
    }

    public String getMovie_adult() {
        return movie_adult;
    }

    public void setMovie_adult(String movie_adult) {
        this.movie_adult = movie_adult;
    }

    public String getMovie_overview() {
        return movie_overview;
    }

    public void setMovie_overview(String movie_overview) {
        this.movie_overview = movie_overview;
    }

    public String getMovie_release_date() {
        return movie_release_date;
    }

    public void setMovie_release_date(String movie_release_date) {
        this.movie_release_date = movie_release_date;
    }
}
