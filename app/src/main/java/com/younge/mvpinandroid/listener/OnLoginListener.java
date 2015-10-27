package com.younge.mvpinandroid.listener;

import com.younge.mvpinandroid.model.entity.User;

/**
 * Created by younge on 2015/10/23 0023.
 */
public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();
}
