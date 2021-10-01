package com.client.Presenters;


import com.client.Activities.RegisterActivity;
import com.client.Contracts.RegisterContract;
import com.client.Entities.User;


public class RegisterActivityPresenter implements RegisterContract.RegisterPresenter {
    private RegisterActivity activity;

    public RegisterActivityPresenter(RegisterActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onRegisterButtonClick(User user) {

    }
}
