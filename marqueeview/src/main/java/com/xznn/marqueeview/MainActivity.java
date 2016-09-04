package com.xznn.marqueeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    private MarqueeView marqueeView;
    private ImageView mIv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        marqueeView = (MarqueeView) findViewById(R.id.marquee_view);
        initMarqueeView();

    }

    private void setMarqueeViewVisibility() {
            if(map.size() == 0) {
                marqueeView.setVisibility(View.GONE);
            } else {
                marqueeView.setVisibility(View.VISIBLE);
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

    public int ID = 10002;
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
        if (map.containsKey(10002)) {
            marqueeView.removeViewInQueue(map.get(10002));
            map.remove(10002);
        }
        setMarqueeViewVisibility();
    }

}
