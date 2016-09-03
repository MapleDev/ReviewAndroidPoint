package com.xznn.mvp_practice;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xznn.mvp_practice.view.BaseActivity;

public class LoginActivity extends BaseActivity {


    private TextView mTextView;

    /**
     * View点击
     *
     * @param v
     **/
    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.tv:
                showToast("textView clicked~~~ ");
                break;
        }
    }

    /**
     * [初始化参数]
     * 解析bundle内容 或 设置是否旋转，沉浸，全屏
     *
     * @param parms
     */
    @Override
    public void initParms(Bundle parms) {
//        setSteepStatusBar(false);
//        setAllowFullScreen(false);
    }

    /**
     * [绑定视图]
     *
     * @return
     */
    @Override
    public View bindView() {
        return null;
    }

    /**
     * [绑定布局]
     *
     * @return
     */
    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    /**
     * [初始化控件]
     *
     * @param view
     */
    @Override
    public void initView(View view) {
        mTextView = $(R.id.tv);
    }

    /**
     * [设置监听]
     */
    @Override
    public void setListener() {
        mTextView.setOnClickListener(this);
    }

    /**
     * [业务操作]
     *
     * @param mContext
     */
    @Override
    public void doBusiness(Context mContext) {
        mTextView.setText(" [业务操作] ");
    }
}
