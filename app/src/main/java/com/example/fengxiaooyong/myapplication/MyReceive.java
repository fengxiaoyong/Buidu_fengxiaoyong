package com.example.fengxiaooyong.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import java.lang.Object;
/**
 * Created by fengxiaooyong on 17/10/28.
 */

public class MyReceive  extends BroadcastReceiver{

    final private String TAG="呵呵";

    @Override
    public void onReceive(Context context,Intent intent){
        Log.e(TAG,"onReceive已经收到");
        Log.e(TAG,context.getPackageName());
        Log.e(TAG,intent.getAction());
        Bundle bd=intent.getExtras();
        //pdus是获取短信的key;
        Object[] objects=(Object[]) bd.get("pdus");
        SmsMessage[] messages=new SmsMessage[objects.length];
        for(int i=0;i<messages.length;i++){
            //循环取出短信的内容
            messages[i]=SmsMessage.createFromPdu((byte[])objects[i]);
            //getMessageBody一次只能取140个字节，如果body内容较多，需要多次取出；
            Log.v(TAG,messages[i].getMessageBody());
        }
        //短信的地址只在第一个message里存储；
        Log.v(TAG,messages[0].getOriginatingAddress());
        setResultData("123232323");
        getResultData();
        intent.getStringExtra("传送");




    }

}
