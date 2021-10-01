package com.client.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.client.Activities.MoviesActivity;
import com.client.Entities.Movie;
import com.client.R;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> {

    private MoviesActivity moviesActivity;
    private List<Movie> moviesList;

    public MoviesAdapter(MoviesActivity moviesActivity, List<Movie> moviesList) {
        this.moviesActivity = moviesActivity;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_movie, parent, false);

        return new MoviesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {

        holder.tvMovieTitle.setText(moviesList.get(position).getTitle());
        //holder.tvMovieRatings.setText(moviesList.get(position));
        holder.tvReleaseDate.setText(moviesList.get(position).getProductionDate().toString());

        Glide.with(moviesActivity)
                .load(moviesList.get(position).getImageURL())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
        .into(holder.ivMovieThumb);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // moviesActiv on click listener
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}

class MoviesViewHolder extends RecyclerView.ViewHolder {

    public TextView tvMovieTitle;

    public TextView tvMovieRatings;

    public TextView tvReleaseDate;

    public ImageView ivMovieThumb;

    public MoviesViewHolder(View itemView) {
        super(itemView);
        tvMovieTitle = itemView.findViewById(R.id.movie_title);
        tvReleaseDate = itemView.findViewById(R.id.movie_release);
        tvMovieRatings = itemView.findViewById(R.id.movie_rating);
        ivMovieThumb = itemView.findViewById(R.id.movie_thumb);
    }
}
