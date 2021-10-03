package com.client.Presenters;

import com.client.Activities.MoviesActivity;
import com.client.Contracts.MoviesContract;
import com.client.DTOs.MovieForResponseDTO;
import com.client.Entities.Movie;
import com.client.Models.MoviesModel;

import java.util.List;

public class MoviesActivityPresenter implements MoviesContract.MoviesPresenter {
    private MoviesActivity activity;
    private MoviesModel model;

    public MoviesActivityPresenter(MoviesActivity activity) {
        this.activity = activity;
        this.model = new MoviesModel(activity);
    }

    @Override
    public void onGetAll() {
        model.getAllMoviesCall(new MoviesContract.MoviesModel.OnRecieveList() {
            @Override
            public void onResponse(List<MovieForResponseDTO> movies) {
                activity.setDataToRV(movies);
            }
        });
    }

    @Override
    public void onAddMovie() {

    }


    @Override
    public void onGetMovie() {

    }

    @Override
    public void onGetSeen() {

    }
}
