package com.client.Presenters;


import com.client.Activities.RegisterActivity;
import com.client.Contracts.RegisterContract;
import com.client.DTOs.UserForRegisterDTO;
import com.client.DTOs.UserToResponseDTO;
import com.client.Entities.User;
import com.client.Models.RegisterModel;


public class RegisterActivityPresenter implements RegisterContract.RegisterPresenter {
    private RegisterActivity activity;
    private RegisterModel model;

    public RegisterActivityPresenter(RegisterActivity activity) {
        this.activity = activity;
        model = new RegisterModel(activity);
    }


    @Override
    public void onRegisterButtonClick(UserForRegisterDTO user) {
        model.registerCall(user, new RegisterContract.RegisterModel.OnRegisterListener() {
            @Override
            public void onResponse(UserToResponseDTO userResponse) {
                activity.onRegisterSuccess();
            }
        });
    }
}
