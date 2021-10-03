package com.client.Models;

import com.client.Activities.MyCommentsActivity;
import com.client.Contracts.MyCommentsContract;
import com.client.DTOs.CommentForRecieveDTO;
import com.client.DTOs.MovieForResponseDTO;
import com.client.LocalStorage.Storage;
import com.client.Network.ApiClient;
import com.client.Network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyCommentsModel implements MyCommentsContract.MyCommentsModel {
    private String TOKEN;

    public MyCommentsModel(MyCommentsActivity activity) {
        TOKEN = "Bearer " + Storage.getUser(activity).getToken();
    }

    @Override
    public void getMyComments(OnResponse onResponse) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<CommentForRecieveDTO>> call = apiService.getCommentByUser(TOKEN);
        call.enqueue(new Callback<List<CommentForRecieveDTO>>() {
            @Override
            public void onResponse(Call<List<CommentForRecieveDTO>> call, Response<List<CommentForRecieveDTO>> response) {
                onResponse.onResponseCall(response.body());
            }

            @Override
            public void onFailure(Call<List<CommentForRecieveDTO>> call, Throwable t) {

            }
        });
    }
}
