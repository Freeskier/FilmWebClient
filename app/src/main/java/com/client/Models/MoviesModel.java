package com.client.Models;

import com.client.Activities.MoviesActivity;
import com.client.Contracts.MoviesContract;
import com.client.DTOs.MovieForAddDTO;
import com.client.DTOs.MovieForAddSeenDTO;
import com.client.DTOs.MovieForResponseDTO;
import com.client.LocalStorage.Storage;
import com.client.Network.ApiClient;
import com.client.Network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesModel implements MoviesContract.MoviesModel {

    private MoviesActivity activity;
    public String TOKEN;

    public MoviesModel(MoviesActivity activity) {
        this.activity = activity;
        TOKEN = "Bearer " + Storage.getUser(activity).getToken();
    }

    @Override
    public void getAllMoviesCall(OnRecieveList onRecieve) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<MovieForResponseDTO>> call = apiService.getAllMovies(TOKEN);
        call.enqueue(new Callback<List<MovieForResponseDTO>>() {
            @Override
            public void onResponse(Call<List<MovieForResponseDTO>> call, Response<List<MovieForResponseDTO>> response) {
                onRecieve.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieForResponseDTO>> call, Throwable t) {

            }
        });
    }

    @Override
    public void addMovie(MovieForAddDTO movie) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.addMovie(movie, TOKEN);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }


    @Override
    public void getMovie(int movieId, OnRecieve onRecieve) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieForResponseDTO> call = apiService.getMovie(movieId, TOKEN);
        call.enqueue(new Callback<MovieForResponseDTO>() {
            @Override
            public void onResponse(Call<MovieForResponseDTO> call, Response<MovieForResponseDTO> response) {
                onRecieve.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<MovieForResponseDTO> call, Throwable t) {

            }
        });

    }

    @Override
    public void getSeen(OnRecieveList onRecieve) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<MovieForResponseDTO>> call = apiService.getSeen(TOKEN);
        call.enqueue(new Callback<List<MovieForResponseDTO>>() {
            @Override
            public void onResponse(Call<List<MovieForResponseDTO>> call, Response<List<MovieForResponseDTO>> response) {
                onRecieve.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieForResponseDTO>> call, Throwable t) {

            }
        });
    }
}
