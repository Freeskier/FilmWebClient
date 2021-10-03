package com.client.Models;

import android.widget.LinearLayout;

import com.client.Activities.MovieDetailsActivity;

import com.client.Contracts.MovieDetailsContract;
import com.client.CustomViews.StarImageView;
import com.client.DTOs.CommentForAddDTO;
import com.client.DTOs.CommentForRecieveDTO;
import com.client.DTOs.MovieForResponseDTO;
import com.client.DTOs.RatingForAddDTO;
import com.client.LocalStorage.Storage;
import com.client.Network.ApiClient;
import com.client.Network.ApiInterface;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsModel implements MovieDetailsContract.MovieDetailsModel {
    private MovieDetailsActivity activity;
    public String TOKEN;

    public MovieDetailsModel(MovieDetailsActivity activity) {
        this.activity = activity;
        TOKEN = "Bearer " + Storage.getUser(activity).getToken();
    }

    @Override
    public void getMovieDetailsCall(int movieId, OnRecieve onRecieve) {
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
    public void getCommentsForMovie(int movieId, OnRecieveComments onRecieve) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<CommentForRecieveDTO>> call = apiService.getCommentByMovie(movieId, TOKEN);
        call.enqueue(new Callback<List<CommentForRecieveDTO>>() {
            @Override
            public void onResponse(Call<List<CommentForRecieveDTO>> call, Response<List<CommentForRecieveDTO>> response) {
                onRecieve.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<CommentForRecieveDTO>> call, Throwable t) {

            }
        });
    }

    @Override
    public void addComment(CommentForAddDTO comment, AddCallback callback) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ResponseBody> call = apiService.addComment(comment, TOKEN);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                callback.onResponse();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void addRating(RatingForAddDTO rating, AddCallback callback) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ResponseBody> call = apiService.addRating(rating, TOKEN);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                callback.onResponse();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void addToSeen(int movieId, AddCallback callback) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ResponseBody> call = apiService.addSeen(movieId, TOKEN);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                callback.onResponse();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void deleteFromSeen(int movieId, AddCallback callback) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ResponseBody> call = apiService.deleteSeen(movieId, TOKEN);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                callback.onResponse();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void deleteRating(int movieId, AddCallback callback) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ResponseBody> call = apiService.deteleRating(movieId, TOKEN);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                callback.onResponse();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
