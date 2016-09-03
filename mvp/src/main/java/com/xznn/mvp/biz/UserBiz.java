package com.xznn.mvp.biz;

import android.os.SystemClock;

import com.xznn.mvp.bean.User;

/**
 * @author MapleDev
 * @time 16/08/18  21:57
 * @desc ${TODD}
 */
public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                //模拟登录成功
                if ("xznn".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}

