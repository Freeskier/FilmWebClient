package com.client.Presenters;

import com.client.Activities.LoginActivity;
import com.client.Contracts.LoginContract;
import com.client.DTOs.UserForLoginDTO;
import com.client.DTOs.UserToResponseDTO;
import com.client.Entities.User;
import com.client.LocalStorage.Storage;
import com.client.LocalStorage.StorageUser;
import com.client.Models.LoginModel;


public class LoginActivityPresenter implements LoginContract.LoginPresenter {
    private LoginActivity activity;
    private LoginModel loginModel;

    public LoginActivityPresenter(LoginActivity activity)
    {
        this.activity = activity;
        loginModel = new LoginModel();
    }

    @Override
    public void onLoginButtonClick(User user) {
        UserForLoginDTO userForLogin = new UserForLoginDTO(user.getLogin(), user.getPassword());
        loginModel.loginCall(userForLogin,
                new LoginContract.LoginModel.OnLoginListener() {
                    @Override
                    public void onResponse(UserToResponseDTO userResponse) {
                        Storage.setUser(new StorageUser(userResponse.getID(), userResponse.getToken()), activity);
                        activity.onLoginSuccess();
                    }
                });
    }

}
