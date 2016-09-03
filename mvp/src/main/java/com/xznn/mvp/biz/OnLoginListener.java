package com.xznn.mvp.biz;

import com.xznn.mvp.bean.User;

/**
 * @author MapleDev
 * @time 16/08/18  21:58
 * @desc ${TODD}
 */
public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
