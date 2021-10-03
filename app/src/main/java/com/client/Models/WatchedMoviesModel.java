package com.client.Models;

import com.client.Activities.MoviesActivity;
import com.client.Activities.WatchedMoviesActivity;
import com.client.Contracts.WatchedMoviesContract;
import com.client.DTOs.MovieForResponseDTO;
import com.client.LocalStorage.Storage;
import com.client.Network.ApiClient;
import com.client.Network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WatchedMoviesModel implements WatchedMoviesContract.WatchedMoviesModel {

    private WatchedMoviesActivity activity;
    public String TOKEN;

    public WatchedMoviesModel(WatchedMoviesActivity activity) {
        this.activity = activity;
        TOKEN = "Bearer " + Storage.getUser(activity).getToken();
    }

    @Override
    public void getWatchedMovies(OnResponse responsee) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<MovieForResponseDTO>> call = apiService.getSeen(TOKEN);
        call.enqueue(new Callback<List<MovieForResponseDTO>>() {
            @Override
            public void onResponse(Call<List<MovieForResponseDTO>> call, Response<List<MovieForResponseDTO>> response) {
                responsee.response(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieForResponseDTO>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getMovie(int movieId, OnResponseMovie responsee) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<MovieForResponseDTO> call = apiService.getMovie(movieId, TOKEN);
        call.enqueue(new Callback<MovieForResponseDTO>() {
            @Override
            public void onResponse(Call<MovieForResponseDTO> call, Response<MovieForResponseDTO> response) {
                responsee.response(response.body());
            }

            @Override
            public void onFailure(Call<MovieForResponseDTO> call, Throwable t) {

            }
        });
    }
}
