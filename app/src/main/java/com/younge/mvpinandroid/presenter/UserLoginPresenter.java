package com.younge.mvpinandroid.presenter;

import android.os.Handler;

import com.younge.mvpinandroid.listener.OnLoginListener;
import com.younge.mvpinandroid.model.UserModel;
import com.younge.mvpinandroid.model.entity.User;
import com.younge.mvpinandroid.model.impl.UserModelImpl;
import com.younge.mvpinandroid.ui.view.IUserLoginView;

/**
 * Created by Administrator on 2015/10/23 0023.
 */
public class UserLoginPresenter {

    private UserModel userModel;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView)
    {
        this.userLoginView = userLoginView;
        this.userModel = new UserModelImpl();
    }

    public void login()
    {
        userLoginView.showLoading();
        userModel.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener()
        {
            @Override
            public void loginSuccess(final User user)
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed()
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear()
    {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
