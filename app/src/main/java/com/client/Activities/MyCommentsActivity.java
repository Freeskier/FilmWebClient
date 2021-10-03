package com.client.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.client.Adapters.CommentsAdapter;
import com.client.Contracts.MyCommentsContract;
import com.client.DTOs.CommentForRecieveDTO;
import com.client.Presenters.MyCommentsActivityPresenter;
import com.client.R;

import java.util.ArrayList;
import java.util.List;

public class MyCommentsActivity extends AppCompatActivity implements MyCommentsContract.MyCommentsView {

    private MyCommentsActivityPresenter presenter;
    private RecyclerView commentsRV;
    private CommentsAdapter commentsAdapter;
    private List<CommentForRecieveDTO> comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_comments);
        setTitle("My comments");
        connectViews();
        presenter.getMyComments();
    }

    private void connectViews() {
        commentsRV = findViewById(R.id.myCommentsRV);

        comments = new ArrayList<>();
        presenter = new MyCommentsActivityPresenter(this);
        commentsAdapter = new CommentsAdapter(comments);
        commentsRV.setLayoutManager(new LinearLayoutManager(this));
        commentsRV.setItemAnimator(new DefaultItemAnimator());
        commentsRV.setAdapter(commentsAdapter);
    }

    @Override
    public void onGetMyComments(List<CommentForRecieveDTO> comments) {
        commentsAdapter.updateData(comments);
        commentsAdapter.notifyDataSetChanged();
    }
}