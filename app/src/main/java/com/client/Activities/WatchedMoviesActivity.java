package com.client.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.client.Adapters.MoviesAdapter;
import com.client.Adapters.WatchedMoviesAdapter;
import com.client.Contracts.WatchedMoviesContract;
import com.client.DTOs.MovieForResponseDTO;
import com.client.Presenters.WatchedMoviesActivityPresenter;
import com.client.R;

import java.util.ArrayList;
import java.util.List;

public class WatchedMoviesActivity extends AppCompatActivity implements WatchedMoviesContract.WatchedMoviesView {

    private WatchedMoviesActivityPresenter presenter;
    private RecyclerView recyclerView;
    private List<MovieForResponseDTO> movies;
    private GridLayoutManager mLayoutManager;
    private WatchedMoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watched_movies);
        setTitle("Watched movies");
        connectViews();
        presenter.getWatchedMovies();
    }

    @Override
    public void onResume(){
        super.onResume();
        presenter.getWatchedMovies();
    }

    private void connectViews() {
        presenter = new WatchedMoviesActivityPresenter(this);
        movies = new ArrayList<>();
        moviesAdapter = new WatchedMoviesAdapter(this, movies, new WatchedMoviesAdapter.OnClick() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(getApplicationContext(), MovieDetailsActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.moviesWatchedRV);

        mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(moviesAdapter);
    }


    @Override
    public void onGetWatchedMovies(List<MovieForResponseDTO> movies) {
        moviesAdapter.UpdateMovies(movies);
        moviesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetMovie(MovieForResponseDTO movie) {

    }
}