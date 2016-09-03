package com.xznn.my_service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ServiceConnection mConn  = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("DDD", "====== 所在方法：onServiceConnected([name, service]) ======");
            MyService.MyBinder myBinder = (MyService.MyBinder) service;
            mMMyService = myBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("DDD", "====== 所在方法：onServiceDisconnected([name]) ======");
        }
    };
    private MyService mMyService;
    private MyService mMMyService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = new Intent(this, MyService.class);
        startService(intent);
//        bindService(intent, mConn, Context.BIND_AUTO_CREATE);

    }

    public void onStartService(View v) {

        mMMyService.fun("XXOO");

        ////////////////


//        MyIntentService.startActionFoo(this,"param1", "param2");

    }
}
