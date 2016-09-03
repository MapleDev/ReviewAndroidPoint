package com.xznn.my_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {


    class MyBinder extends Binder {
       public MyService getService(){
           return MyService.this;
       }
    }


    public MyService() {
        super();
        Log.d("DDD", "====== 所在方法：MyService([]) ======");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("DDD", "====== 所在方法：onBind([intent]) ======");
        return new MyBinder();
    }



    public void fun(String s) {
        Log.d("DDD", "====== 所在方法：fun([s]) ======" + s);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
