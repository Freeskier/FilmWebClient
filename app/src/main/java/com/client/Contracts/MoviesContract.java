package com.client.Contracts;

import com.client.DTOs.MovieForAddDTO;
import com.client.DTOs.MovieForAddSeenDTO;
import com.client.DTOs.MovieForResponseDTO;
import com.client.DTOs.UserForLoginDTO;
import com.client.DTOs.UserToResponseDTO;
import com.client.Entities.Movie;
import com.client.Entities.User;

import java.util.List;

public interface MoviesContract {
    interface MoviesPresenter {
        void onGetAll();
        void onAddMovie();

        void onGetMovie();
        void onGetSeen();
    }

    interface MoviesView
    {
        void setDataToRV(List<MovieForResponseDTO> movies);
    }

    interface MoviesModel {
        interface OnRecieveList {
            void onResponse(List<MovieForResponseDTO> movies);
        }
        interface OnRecieve {
            void onResponse(MovieForResponseDTO movie);
        }
        void getAllMoviesCall(OnRecieveList onRecieve);
        void addMovie(MovieForAddDTO movie);
        void getMovie(int movieId, OnRecieve onRecieve);
        void getSeen(OnRecieveList onRecieve);
    }
}
