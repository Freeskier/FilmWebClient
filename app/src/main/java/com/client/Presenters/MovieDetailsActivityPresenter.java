package com.client.Presenters;

import com.client.Activities.MovieDetailsActivity;
import com.client.Contracts.MovieDetailsContract;
import com.client.DTOs.CommentForAddDTO;
import com.client.DTOs.CommentForRecieveDTO;
import com.client.DTOs.MovieForResponseDTO;
import com.client.DTOs.RatingForAddDTO;
import com.client.Models.MovieDetailsModel;

import java.util.List;

public class MovieDetailsActivityPresenter implements MovieDetailsContract.MovieDetailsPresenter {

    private MovieDetailsActivity activity;
    private MovieDetailsModel model;

    public MovieDetailsActivityPresenter(MovieDetailsActivity activity) {
        this.activity = activity;
        model = new MovieDetailsModel(activity);
    }

    @Override
    public void getMovieDetails(int movieId) {
        model.getMovieDetailsCall(movieId, new MovieDetailsContract.MovieDetailsModel.OnRecieve() {
            @Override
            public void onResponse(MovieForResponseDTO movie) {
                activity.onMovieDetails(movie);
            }
        });
    }

    @Override
    public void getCommentsForMovie(int movieId) {
        model.getCommentsForMovie(movieId, new MovieDetailsContract.MovieDetailsModel.OnRecieveComments() {
            @Override
            public void onResponse(List<CommentForRecieveDTO> comments) {
                activity.onCommentsForMovie(comments);
            }
        });
    }

    @Override
    public void addComment(CommentForAddDTO comment) {
        model.addComment(comment, new MovieDetailsContract.MovieDetailsModel.AddCallback() {
            @Override
            public void onResponse() {
                activity.onAddCommentCallback();
            }
        });
    }

    @Override
    public void addRating(RatingForAddDTO rating) {
        model.addRating(rating, new MovieDetailsContract.MovieDetailsModel.AddCallback() {
            @Override
            public void onResponse() {
                activity.onAddRatingCallback();
            }
        });
    }

    @Override
    public void addToSeen(int movieId) {
        model.addToSeen(movieId, new MovieDetailsContract.MovieDetailsModel.AddCallback() {
            @Override
            public void onResponse() {
                activity.onAddToSeen();
            }
        });
    }

    @Override
    public void deleteFromSeen(int movieId) {
        model.deleteFromSeen(movieId, new MovieDetailsContract.MovieDetailsModel.AddCallback() {
            @Override
            public void onResponse() {
                activity.onDeleteFromSeen();
            }
        });
    }

    @Override
    public void deleteRating(int movieId) {
        model.deleteRating(movieId, new MovieDetailsContract.MovieDetailsModel.AddCallback() {
            @Override
            public void onResponse() {
                activity.onDeleteRating();
            }
        });
    }
}
