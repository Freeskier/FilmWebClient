package com.client.Contracts;

import android.content.Context;

import com.client.DTOs.UserForLoginDTO;
import com.client.DTOs.UserToResponseDTO;
import com.client.Entities.User;


public interface LoginContract {
    interface LoginPresenter {
        void onLoginButtonClick(User user);
    }

    interface LoginView
    {
        void onLoginSuccess();
    }

    interface LoginModel {
        interface OnLoginListener {
            void onResponse(UserToResponseDTO userResponse);
        }

        void loginCall(UserForLoginDTO user, OnLoginListener onLoginListener);
    }
}
