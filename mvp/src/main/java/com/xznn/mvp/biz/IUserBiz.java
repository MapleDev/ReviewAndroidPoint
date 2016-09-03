package com.xznn.mvp.biz;

/**
 * @author MapleDev
 * @time 16/08/18  21:56
 * @desc ${TODD}
 */
public interface IUserBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}
