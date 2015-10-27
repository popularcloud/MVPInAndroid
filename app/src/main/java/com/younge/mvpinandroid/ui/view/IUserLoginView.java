package com.younge.mvpinandroid.ui.view;

import com.younge.mvpinandroid.model.entity.User;

/**
 * Created by younge on 2015/10/23 0023.
 */
public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
