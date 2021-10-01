package com.client.Network;

import com.client.DTOs.MovieForResponseDTO;
import com.client.DTOs.UserForLoginDTO;
import com.client.DTOs.UserForRegisterDTO;
import com.client.DTOs.UserToResponseDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("auth/login")
    Call<UserToResponseDTO> login(@Body UserForLoginDTO user);

    @POST("auth/register")
    Call<UserToResponseDTO> register(@Body UserForRegisterDTO user);

    @GET("movie/getAll")
    Call<List<MovieForResponseDTO>> getAllMovies();

    @GET("movie/get/{id}")
    Call<MovieForResponseDTO> getMovie(@Path("id") int movieId);
}
