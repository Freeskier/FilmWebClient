package com.client.Contracts;

import com.client.DTOs.CommentForAddDTO;
import com.client.DTOs.CommentForRecieveDTO;
import com.client.DTOs.MovieForResponseDTO;
import com.client.DTOs.RatingForAddDTO;

import java.util.List;

public interface MovieDetailsContract {
    interface MovieDetailsModel {
        interface OnRecieve {
            void onResponse(MovieForResponseDTO movie);
        }
        interface OnRecieveComments {
            void onResponse(List<CommentForRecieveDTO> comments);
        }
        interface AddCallback {
            void onResponse();
        }

        void getMovieDetailsCall(int movieId, OnRecieve onRecieve);
        void getCommentsForMovie(int movieId, OnRecieveComments onRecieve);
        void addComment(CommentForAddDTO comment, AddCallback callback);
        void addRating(RatingForAddDTO rating, AddCallback callback);
        void addToSeen(int movieId, AddCallback callback);
        void deleteFromSeen(int movieId, AddCallback callback);
        void deleteRating(int movieId, AddCallback callback);
    }

    interface MovieDetailsView {
        void onMovieDetails(MovieForResponseDTO movie);
        void onCommentsForMovie(List<CommentForRecieveDTO> comments);
        void onAddCommentCallback();
        void onAddRatingCallback();
        void onAddToSeen();
        void onDeleteFromSeen();
        void onDeleteRating();
    }

    interface MovieDetailsPresenter {
        void getMovieDetails(int movieId);
        void getCommentsForMovie(int movieId);
        void addComment(CommentForAddDTO comment);
        void addRating(RatingForAddDTO rating);
        void addToSeen(int movieId);
        void deleteFromSeen(int movieId);
        void deleteRating(int movieId);
    }
}
