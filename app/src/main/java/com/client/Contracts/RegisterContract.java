package com.client.Contracts;

import android.content.Context;

import com.client.DTOs.UserForRegisterDTO;
import com.client.DTOs.UserToResponseDTO;
import com.client.Entities.User;


public interface RegisterContract {
    interface RegisterPresenter {
        void onRegisterButtonClick(UserForRegisterDTO user);
    }

    interface RegisterView
    {
        void onRegisterSuccess();
    }

    interface RegisterModel {
        interface OnRegisterListener {
            void onResponse(UserToResponseDTO userResponse);
        }

        void registerCall(UserForRegisterDTO user, OnRegisterListener listener);
    }
}
