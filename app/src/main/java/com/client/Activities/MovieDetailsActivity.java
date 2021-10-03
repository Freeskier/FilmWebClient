package com.client.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.client.Adapters.CommentsAdapter;
import com.client.Contracts.MovieDetailsContract;
import com.client.CustomViews.StarImageView;
import com.client.DTOs.CommentForAddDTO;
import com.client.DTOs.CommentForRecieveDTO;
import com.client.DTOs.MovieForResponseDTO;
import com.client.DTOs.RatingForAddDTO;
import com.client.Presenters.MovieDetailsActivityPresenter;
import com.client.R;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailsActivity extends AppCompatActivity implements MovieDetailsContract.MovieDetailsView {

    private int movieId;
    private MovieDetailsActivityPresenter presenter;
    private ImageView seenIV, movieIV;
    private TextView descriptionTV, ratingTV, dateTV, titleTV;
    private CommentsAdapter commentsAdapter;
    private List<CommentForRecieveDTO> comments;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private EditText commentET;
    private NestedScrollView scrollView;
    private List<StarImageView> stars;
    private LinearLayout starsLayout;
    private ImageView deleteRating;
    private boolean isSeen, isRated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        connectViews();
    }

    void connectViews(){
        seenIV = findViewById(R.id.watchedIV);
        movieIV = findViewById(R.id.movieIV);
        descriptionTV = findViewById(R.id.descriptionTV);
        ratingTV = findViewById(R.id.rating);
        dateTV = findViewById(R.id.productionDate);
        recyclerView = findViewById(R.id.commentsRV);
        commentET = findViewById(R.id.commentET);
        titleTV = findViewById(R.id.details_titleTV);
        scrollView = findViewById(R.id.scrollViewDet);
        starsLayout = findViewById(R.id.starsLL);

        stars = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            StarImageView s = new StarImageView(this, i);
            s.setImageResource(R.drawable.ic_big_star_outlined);
            s.setColorFilter(getApplicationContext().getResources().getColor(R.color.grey));

            s.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!isRated) {
                        StarImageView star = (StarImageView) v;
                        setStars(star.getPosition());
                        presenter.addRating(new RatingForAddDTO(movieId, star.getPosition() + 1));
                    }
                    else {
                        Toast.makeText(v.getContext(), "You need to delete your rating before add changes.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            starsLayout.addView(s);
            stars.add(s);
        }
        deleteRating = new ImageView(this);
        deleteRating.setImageResource(R.drawable.ic_delete);
        deleteRating.setVisibility(View.INVISIBLE);
        deleteRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteStars();
                presenter.deleteRating(movieId);
            }
        });
        starsLayout.addView(deleteRating);

        movieId = getIntent().getExtras().getInt("movieId");
        presenter = new MovieDetailsActivityPresenter(this);
        comments = new ArrayList<>();
        commentsAdapter = new CommentsAdapter(comments);
        presenter.getMovieDetails(movieId);
        presenter.getCommentsForMovie(movieId);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(commentsAdapter);
    }

    public void watchedClick(View view) {
        if(isSeen)
            presenter.deleteFromSeen(movieId);
        else
            presenter.addToSeen(movieId);
    }

    @Override
    public void onMovieDetails(MovieForResponseDTO movie) {

        Glide.with(this)
                .load(movie.getImageURL())
                .into(movieIV);

        descriptionTV.setText(movie.getDescriptionLong());
        dateTV.setText(movie.getProductionDate());
        ratingTV.setText(Float.toString(movie.getRating()));
        titleTV.setText(movie.getTitle());
        isSeen = movie.isSeen();
        if(movie.getUserRating() != -1) {
            setStars(movie.getUserRating() - 1);
            isRated = true;
        }
        else
            isRated = false;
        setSeen(isSeen);
    }

    @Override
    public void onCommentsForMovie(List<CommentForRecieveDTO> comment) {
        commentsAdapter.updateData(comment);
        commentsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAddCommentCallback() {
        presenter.getCommentsForMovie(movieId);
        Toast.makeText(this, "Succesfully added comment!", Toast.LENGTH_SHORT).show();
        commentET.setText("");
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

    @Override
    public void onAddRatingCallback() {
        presenter.getMovieDetails(movieId);
        Toast.makeText(this, "Thanks for rating!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAddToSeen() {
        presenter.getMovieDetails(movieId);
        Toast.makeText(this, "Added to seen movies!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteFromSeen() {
        presenter.getMovieDetails(movieId);
        Toast.makeText(this, "Deleted from seen movies!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteRating() {
        presenter.getMovieDetails(movieId);
        Toast.makeText(this, "Rating has been deleted.", Toast.LENGTH_SHORT).show();
    }

    public void addComment(View view) {
        CommentForAddDTO comment = new CommentForAddDTO(commentET.getText().toString(), movieId);
        presenter.addComment(comment);
    }

    private void setStars(int position){
        for (int i = 0; i < 10; i++) {
            stars.get(i).setImageResource(R.drawable.ic_big_star);
            stars.get(i).setColorFilter(getApplicationContext().getResources().getColor(R.color.grey));
        }

        for (int i = 0; i <= position; i++){
            stars.get(i).setImageResource(R.drawable.ic_big_star);
            stars.get(i).setColorFilter(getApplicationContext().getResources().getColor(R.color.yellow));
        }
        deleteRating.setVisibility(View.VISIBLE);
    }

    private void deleteStars(){
        deleteRating.setVisibility(View.INVISIBLE);
        for (int i = 0; i < 10; i++) {
            stars.get(i).setImageResource(R.drawable.ic_big_star_outlined);
            stars.get(i).setColorFilter(getApplicationContext().getResources().getColor(R.color.grey));
        }
    }

    private void setSeen(boolean isSeen){
        if(isSeen)
            seenIV.setColorFilter(getApplicationContext().getResources().getColor(R.color.oragne));
        else
            seenIV.setColorFilter(getApplicationContext().getResources().getColor(R.color.grey));

    }
}