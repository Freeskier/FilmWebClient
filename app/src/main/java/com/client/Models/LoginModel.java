package com.client.Models;

import android.content.Context;

import com.client.Contracts.LoginContract;
import com.client.DTOs.MovieForResponseDTO;
import com.client.DTOs.UserForLoginDTO;
import com.client.DTOs.UserToResponseDTO;
import com.client.Entities.User;
import com.client.Network.ApiClient;
import com.client.Network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements LoginContract.LoginModel {

    @Override
    public void loginCall(UserForLoginDTO user, OnLoginListener onLoginListener) {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<UserToResponseDTO> call = apiService.login(user);
        call.enqueue(new Callback<UserToResponseDTO>() {
            @Override
            public void onResponse(Call<UserToResponseDTO> call, Response<UserToResponseDTO> response) {
                onLoginListener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<UserToResponseDTO> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
