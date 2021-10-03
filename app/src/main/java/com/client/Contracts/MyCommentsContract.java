package com.client.Contracts;

import com.client.DTOs.CommentForRecieveDTO;

import java.util.List;

public interface MyCommentsContract {
    interface MyCommentsModel{
        interface OnResponse{
            void onResponseCall(List<CommentForRecieveDTO> comments);
        }

        void getMyComments(OnResponse onResponse);
    }

    interface MyCommentsView{
        void onGetMyComments(List<CommentForRecieveDTO> comments);
    }

    interface MyCommentsPresenter{
        void getMyComments();
    }
}
