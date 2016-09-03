package com.xznn.mvp.view;

import com.xznn.mvp.bean.User;

/**
 * @author MapleDev
 * @time 16/08/18  22:02
 * @desc ${TODD}
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
