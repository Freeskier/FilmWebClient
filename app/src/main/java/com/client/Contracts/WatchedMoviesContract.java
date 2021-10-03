package com.client.Contracts;

import com.client.DTOs.MovieForResponseDTO;

import java.util.List;

public interface WatchedMoviesContract {
    interface WatchedMoviesModel {

        interface OnResponse{
            void response(List<MovieForResponseDTO> movies);
        }

        interface OnResponseMovie{
            void response(MovieForResponseDTO movie);
        }

        void getWatchedMovies(OnResponse response);
        void getMovie(int movieId, OnResponseMovie response);
    }

    interface WatchedMoviesView {
        void onGetWatchedMovies(List<MovieForResponseDTO> movies);
        void onGetMovie(MovieForResponseDTO movie);
    }

    interface WatchedMoviesPresenter {
        void getWatchedMovies();
        void getMovie(int movieId);
    }
}
