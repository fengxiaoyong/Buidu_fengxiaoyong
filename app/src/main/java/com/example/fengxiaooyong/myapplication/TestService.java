package com.example.fengxiaooyong.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by fengxiaooyong on 17/10/27.
 */

public class TestService extends Service {
    private final String TAG="TestService1";

    @Override
    public IBinder onBind(Intent intent){
        Log.e(TAG,"onBind方法被调用了");
        return null;
    }

    @Override
    public void onCreate(){
        Log.e(TAG,"onCreate方法被调用了");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Log.e(TAG,"onStartCommand方法被调用了");
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy(){
        Log.e(TAG,"onDestroy方法被调用了");
        super.onDestroy();
    }

}
