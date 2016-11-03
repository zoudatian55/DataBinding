package com.example.administrator.databindingdemo.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/10/26 0026.
 */

public abstract class NetActivity extends AppCompatActivity{

    protected  static final int REQUEST_FOOD_DATA=1;
    protected static final int ERROR=-1;

    protected Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
         switch (msg.what){
             case ERROR:
                 Toast.makeText(NetActivity.this, "网络出错了", Toast.LENGTH_SHORT).show();
                 break;
             default:
                 messageReceived(msg);
                 break;
         }


        }
    };
    public abstract void messageReceived(Message msg);
}
