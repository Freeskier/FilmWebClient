package com.client.Network;

import com.client.DTOs.CommentForAddDTO;
import com.client.DTOs.CommentForRecieveDTO;
import com.client.DTOs.MovieForAddDTO;
import com.client.DTOs.MovieForAddSeenDTO;
import com.client.DTOs.MovieForResponseDTO;
import com.client.DTOs.RatingForAddDTO;
import com.client.DTOs.UserForLoginDTO;
import com.client.DTOs.UserForRegisterDTO;
import com.client.DTOs.UserToResponseDTO;
import com.client.LocalStorage.Storage;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("auth/login")
    Call<UserToResponseDTO> login(@Body UserForLoginDTO user);

    @POST("auth/register")
    Call<UserToResponseDTO> register(@Body UserForRegisterDTO user);

    @POST("movie/add")
    Call<ResponseBody> addMovie(@Body MovieForAddDTO movie, @Header("Authorization") String token);

    @POST("movie/addSeen/{movieId}")
    Call<ResponseBody> addSeen(@Path("movieId") int movieId, @Header("Authorization") String token);

    @GET("movie/getAll")
    Call<List<MovieForResponseDTO>> getAllMovies(@Header("Authorization") String token);

    @GET("movie/get/{id}")
    Call<MovieForResponseDTO> getMovie(@Path("id") int movieId, @Header("Authorization") String token);

    @GET("movie/getSeen")
    Call<List<MovieForResponseDTO>> getSeen(@Header("Authorization") String token);

    @POST("comment/add")
    Call<ResponseBody> addComment(@Body CommentForAddDTO comment, @Header("Authorization") String token);

    @POST("rating/add")
    Call<ResponseBody> addRating(@Body RatingForAddDTO rating, @Header("Authorization") String token);

    @GET("comment/getByMovie/{movieId}")
    Call<List<CommentForRecieveDTO>> getCommentByMovie(@Path("movieId") int movieId, @Header("Authorization") String token);

    @GET("comment/getByUser")
    Call<List<CommentForRecieveDTO>> getCommentByUser(@Header("Authorization") String token);

    @GET("movie/isSeen/{movieId}")
    Call<Boolean> isSeen(@Path("movieId") int movieId, @Header("Authorization") String token);

    @DELETE("movie/deleteSeen/{movieId}")
    Call<ResponseBody> deleteSeen(@Path("movieId") int movieId, @Header("Authorization") String token);

    @DELETE("rating/{movieId}")
    Call<ResponseBody> deteleRating(@Path("movieId") int movieId, @Header("Authorization") String token);


}
