package com.younge.mvpinandroid.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.younge.mvpinandroid.R;
import com.younge.mvpinandroid.ui.common.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by younge on 2015/10/23 0023.
 */
public class SplashActivity extends BaseActivity{

    @Bind(R.id.iv_splashImg)
    ImageView splashImg;

    private AlphaAnimation start_anima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        startAnimation();
    }

    private void startAnimation(){
        start_anima = new AlphaAnimation(0.3f, 1.0f);
        start_anima.setDuration(2000);
        splashImg.startAnimation(start_anima);
        start_anima.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                redirectTo();//跳转
            }
        });
    }

    private void redirectTo() {
        startActivity(new Intent(this,UserLoginActivity.class));
    }


}
