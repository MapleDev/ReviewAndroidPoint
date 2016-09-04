package com.xznn.marqueeview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    private MarqueeView marqueeView;
    private ImageView mIv2;
    private ImageView mFalang_fg;
    private ImageView mFalang_fg2;
    private FrameLayout mFf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        marqueeView = (MarqueeView) findViewById(R.id.marquee_view);
        mFalang_fg = (ImageView) findViewById(R.id.falang_fg);
        mFalang_fg2 = (ImageView) findViewById(R.id.falang_fg2);
        mFf = (FrameLayout) findViewById(R.id.ff);

        initMarqueeView();
        startPropertyAnim();
    }

    // 动画实际执行
    private void startPropertyAnim() {
        // X轴方向上的坐标
        float translationX = mFalang_fg.getTranslationX();

        // 向右移动 500pix，然后再移动到原来的位置复原。
        // 参数“translationX”指明在x坐标轴位移，即水平位移。
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int screenWidth = wm.getDefaultDisplay().getWidth();

        final ObjectAnimator anim = ObjectAnimator.ofFloat(mFalang_fg, "translationX", 0, screenWidth);
        final ObjectAnimator anim2 = ObjectAnimator.ofFloat(mFalang_fg2, "translationX", -screenWidth, 0);

        anim.setDuration(80000);
        anim2.setDuration(80000);
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim2.setRepeatCount(ValueAnimator.INFINITE);

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                anim.start();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                anim2.start();
            }
        });

        // 正式开始启动执行动画
        anim.start();
    }

    private void setMarqueeViewVisibility() {
        if (map.size() == 0) {
            mFf.setVisibility(View.GONE);
        } else {
            mFf.setVisibility(View.VISIBLE);
        }
    }

    private void initMarqueeView() {


        LinearLayout inflate = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.marquee_content, null);
        marqueeView.addViewInQueue(inflate);
        TextView iv1 = new TextView(this);
        iv1.setText("1");
        marqueeView.addViewInQueue(iv1);
        mIv2 = new ImageView(this);
        mIv2.setImageResource(R.mipmap.ic_launcher);
        marqueeView.addViewInQueue(mIv2);
        TextView iv3 = new TextView(this);
        iv3.setText("3");
        marqueeView.addViewInQueue(iv3);

        marqueeView.setScrollSpeed(8);
        marqueeView.setScrollDirection(MarqueeView.RIGHT_TO_LEFT);
        marqueeView.setViewMargin(15);
        marqueeView.startScroll();

        setMarqueeViewVisibility();

    }

    public int ID = 10000;
    LinkedHashMap<Integer, View> map = new LinkedHashMap<>();

    public void onAdd(View v) {
        LinearLayout inflate = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.marquee_content, null);
        TextView tv = (TextView) inflate.findViewById(R.id.tv);
        tv.setText(ID + "");
        marqueeView.addViewInQueue(inflate);

        map.put(ID++, inflate);

        setMarqueeViewVisibility();
    }

    public void onDel(View v) {
        if (map.containsKey(10000)) {
            marqueeView.removeViewInQueue(map.get(10000));
            map.remove(10000);
        }
        setMarqueeViewVisibility();
    }

}
