package com.client.Presenters;

import com.client.Activities.MyCommentsActivity;
import com.client.Contracts.MyCommentsContract;
import com.client.DTOs.CommentForRecieveDTO;
import com.client.Models.MyCommentsModel;

import java.util.List;

public class MyCommentsActivityPresenter implements MyCommentsContract.MyCommentsPresenter {
    private MyCommentsActivity activity;
    private MyCommentsModel model;

    public MyCommentsActivityPresenter(MyCommentsActivity activity) {
        this.activity = activity;
        model = new MyCommentsModel(activity);
    }

    @Override
    public void getMyComments() {
        model.getMyComments(new MyCommentsContract.MyCommentsModel.OnResponse() {
            @Override
            public void onResponseCall(List<CommentForRecieveDTO> comments) {
                activity.onGetMyComments(comments);
            }
        });
    }
}
