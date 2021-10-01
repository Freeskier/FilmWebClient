package com.client.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.client.Contracts.MoviesContract;
import com.client.R;

public class MoviesActivity extends AppCompatActivity implements MoviesContract.MoviesView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
    }
}