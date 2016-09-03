package com.xznn.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        TextView textView = (TextView) findViewById(R.id.tv);
        textView.setText(this.toString());
        TextView taskIdView = (TextView) findViewById(R.id.taskIdView);
        taskIdView.setText("current task id: " + this.getTaskId());
        Button button = (Button) findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,
                        SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("DDD", "======FirstActivity 所在方法：onNewIntent([intent]) ======");
    }
}