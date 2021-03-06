package com.client.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.client.Adapters.MoviesAdapter;
import com.client.Contracts.MoviesContract;
import com.client.DTOs.MovieForResponseDTO;
import com.client.Entities.Movie;
import com.client.Presenters.MoviesActivityPresenter;
import com.client.R;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity implements MoviesContract.MoviesView {

    private MoviesAdapter moviesAdapter;
    private MoviesActivityPresenter presenter;
    private RecyclerView recyclerView;
    private List<MovieForResponseDTO> movies;
    private GridLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        connectViews();
        presenter = new MoviesActivityPresenter(this);

        presenter.onGetAll();
    }

    @Override
    public void onResume(){
        super.onResume();
        presenter.onGetAll();
    }

    void connectViews(){
        movies = new ArrayList<>();
        moviesAdapter = new MoviesAdapter(this, movies, new MoviesAdapter.OnClick() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(getApplicationContext(), MovieDetailsActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.moviesRV);

        mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(moviesAdapter);
    }

    @Override
    public void setDataToRV(List<MovieForResponseDTO> movies) {
        if(movies == null)
            return;
        moviesAdapter.UpdateMovies(movies);
        moviesAdapter.notifyDataSetChanged();
    }


}