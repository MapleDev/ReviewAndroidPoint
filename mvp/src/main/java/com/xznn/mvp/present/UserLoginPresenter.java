package com.xznn.mvp.present;

import android.os.Handler;

import com.xznn.mvp.bean.User;
import com.xznn.mvp.biz.OnLoginListener;
import com.xznn.mvp.biz.UserBiz;
import com.xznn.mvp.view.IUserLoginView;
import com.xznn.mvp.view.UserLoginActivity;

/**
 * @author MapleDev
 * @time 16/08/18  22:14
 * @desc ${TODD}
 */
public class UserLoginPresenter {

    private final UserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(UserLoginActivity userLoginActivity) {
        this.userLoginView = userLoginActivity;
        this.userBiz = new UserBiz();
    }

    public void login()
    {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener()
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
