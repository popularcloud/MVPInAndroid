package com.younge.mvpinandroid.model.impl;

import com.younge.mvpinandroid.listener.OnLoginListener;
import com.younge.mvpinandroid.model.UserModel;
import com.younge.mvpinandroid.model.entity.User;

/**
 * Created by Administrator on 2015/10/23 0023.
 */
public class UserModelImpl implements UserModel{

    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("zhy".equals(username) && "123".equals(password))
                {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
