package com.client.Presenters;

import com.client.Activities.MoviesActivity;
import com.client.Contracts.MoviesContract;
import com.client.Models.MoviesModel;

public class MoviesActivityPresenter implements MoviesContract.MoviesPresenter {
    private MoviesActivity activity;
    private MoviesModel model;

    public MoviesActivityPresenter(MoviesActivity activity, MoviesModel model) {
        this.activity = activity;
        this.model = model;
    }
}
