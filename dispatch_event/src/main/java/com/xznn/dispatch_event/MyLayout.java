package com.xznn.dispatch_event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * @author MapleDev
 * @time 16/08/14  21:40
 * @desc ${TODD}
 */
public class MyLayout extends LinearLayout {
    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d("DDD", "====== 所在方法：MyLayout([context, attrs]) ======");
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}
