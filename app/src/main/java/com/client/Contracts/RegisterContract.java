package com.client.Contracts;

import android.content.Context;

import com.client.Entities.User;


public interface RegisterContract {
    interface RegisterPresenter {
        void onRegisterButtonClick(User user);
    }

    interface RegisterView
    {
        void onRegisterSuccess();
    }

    interface RegisterInteractor {
        interface OnRegisterListener {
            void onResponse(User userResponse);
        }

        void registerCall(User user, Context context, OnRegisterListener listener);
    }
}
