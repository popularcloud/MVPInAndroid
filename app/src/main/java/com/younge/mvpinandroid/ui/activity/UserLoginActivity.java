package com.younge.mvpinandroid.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.younge.mvpinandroid.MainActivity;
import com.younge.mvpinandroid.R;
import com.younge.mvpinandroid.model.entity.User;
import com.younge.mvpinandroid.presenter.UserLoginPresenter;
import com.younge.mvpinandroid.ui.view.IUserLoginView;

/**
 * Created by younge on 2015/10/23 0023.
 */
public class UserLoginActivity extends Activity implements IUserLoginView {

    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtnClear;
    private Button mBtnLogin;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);
    private ProgressBar mPbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews()
    {
        mEtUsername = (EditText) findViewById(R.id.et_userName);
        mEtPassword = (EditText) findViewById(R.id.et_password);

        mBtnClear = (Button) findViewById(R.id.btn_clear);
        mBtnLogin = (Button) findViewById(R.id.btn_login);

        mPbLoading = (ProgressBar) findViewById(R.id.id_pb_loading);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.clear();
            }
        });
    }




    @Override
    public String getUserName()
    {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword()
    {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName()
    {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword()
    {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading()
    {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading()
    {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user)
    {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void showFailedError()
    {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}
