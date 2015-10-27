package com.younge.mvpinandroid.model;

import com.younge.mvpinandroid.listener.OnLoginListener;

/**
 * Created by Administrator on 2015/10/23 0023.
 */
public interface UserModel {
    public void login(String username, String password, OnLoginListener loginListener);
}
