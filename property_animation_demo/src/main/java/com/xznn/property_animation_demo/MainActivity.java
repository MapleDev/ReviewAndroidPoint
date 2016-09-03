package com.xznn.property_animation_demo;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.image_view);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                // 3、ObjectAnimator实现动画
                // func 01
//                ObjectAnimator.ofFloat(view, "rotationY", 0.0F, 360.0F).setDuration(500).start();

                // func 02
//                ObjectAnimator anim = ObjectAnimator//
//                        .ofFloat(view, "zhy", 1.0F, 0.0F, 1.0f)//
//                        .setDuration(500);//
//                anim.start();
//                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        float animatedValue = (float) animation.getAnimatedValue();
//                        view.setAlpha(animatedValue);
//                        view.setScaleX(animatedValue);
//                        view.setScaleY(animatedValue);
//                    }
//                });

                // func 03
//                PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
//                        0f, 1f);
//                PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
//                        0, 1f);
//                PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
//                        0, 1f);
//                ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY,pvhZ).setDuration(1000).start();


//                4、ValueAnimator实现动画
                ValueAnimator animator = ValueAnimator.ofFloat(0, 500 - mImageView.getHeight());
                animator.setTarget(mImageView);
                animator.setDuration(1000).start();

            }
        });
    }
}
