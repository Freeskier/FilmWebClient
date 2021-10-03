package com.client.Presenters;

import com.client.Activities.WatchedMoviesActivity;
import com.client.Contracts.WatchedMoviesContract;
import com.client.DTOs.MovieForResponseDTO;
import com.client.Models.WatchedMoviesModel;

import java.util.List;

public class WatchedMoviesActivityPresenter implements WatchedMoviesContract.WatchedMoviesPresenter {

    private WatchedMoviesActivity activity;
    private WatchedMoviesModel model;

    public WatchedMoviesActivityPresenter(WatchedMoviesActivity activity) {
        this.activity = activity;
        model = new WatchedMoviesModel(activity);
    }

    @Override
    public void getWatchedMovies() {
        model.getWatchedMovies(new WatchedMoviesContract.WatchedMoviesModel.OnResponse() {
            @Override
            public void response(List<MovieForResponseDTO> movies) {
                activity.onGetWatchedMovies(movies);
            }
        });
    }

    @Override
    public void getMovie(int movieId) {
        model.getMovie(movieId, new WatchedMoviesContract.WatchedMoviesModel.OnResponseMovie() {
            @Override
            public void response(MovieForResponseDTO movie) {
                activity.onGetMovie(movie);
            }
        });
    }
}
