package com.client.Models;

import android.content.Context;

import com.client.Activities.RegisterActivity;
import com.client.Contracts.RegisterContract;
import com.client.DTOs.MovieForResponseDTO;
import com.client.DTOs.UserForRegisterDTO;
import com.client.DTOs.UserToResponseDTO;
import com.client.Entities.User;
import com.client.LocalStorage.Storage;
import com.client.Network.ApiClient;
import com.client.Network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterModel implements RegisterContract.RegisterModel {
    private RegisterActivity activity;

    public RegisterModel(RegisterActivity activity) {
        this.activity = activity;
    }


    @Override
    public void registerCall(UserForRegisterDTO user, OnRegisterListener listener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<UserToResponseDTO> call = apiService.register(user);
        call.enqueue(new Callback<UserToResponseDTO>() {
            @Override
            public void onResponse(Call<UserToResponseDTO> call, Response<UserToResponseDTO> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<UserToResponseDTO> call, Throwable t) {

            }
        });
    }
}
