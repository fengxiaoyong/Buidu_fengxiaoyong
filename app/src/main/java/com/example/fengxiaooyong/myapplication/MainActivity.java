package com.example.fengxiaooyong.myapplication;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnstart;
    private Button btnstop;
    private MyReceive myReceive;
    private LocalBroadcastManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart=(Button) findViewById(R.id.btnstart);
        btnstop=(Button) findViewById(R.id.btnstop);
        manager=LocalBroadcastManager.getInstance(MainActivity.this);

        //动态注册广播
        IntentFilter filter=new IntentFilter();

        filter.addAction("android.provider.Telephony.SMS_RECEIVED");
        filter.addAction("android.intent.action.AIRPLANE_MODE");
        filter.addAction("guangbo");
        Log.e("现在走到我这里了",filter.getAction(0));
        Log.e("现在走到我这里了",filter.getAction(1));
        Log.e("现在走到我这里了",filter.getAction(2));
        Log.e("进程的id", String.valueOf(Process.myPid()));
        Log.e("线程的id",String.valueOf(Thread.currentThread().getId()));
        registerReceiver(myReceive,filter);
        manager.registerReceiver(myReceive,filter);
        Manifest.permission.

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("guangbo");
                intent.putExtra("传送","ssss");
                //sendBroadcast(intent);
                sendBroadcast(intent,"permission.quanli");
                sendOrderedBroadcast(intent,null);
                manager.sendBroadcast(intent);
            }
        });







    }

    @Override
    public void onDestroy(){

        //动态注册完毕后，需要关闭注册的广播接受者
        unregisterReceiver(myReceive);
        manager.unregisterReceiver(myReceive);
        super.onDestroy();
    }


}
