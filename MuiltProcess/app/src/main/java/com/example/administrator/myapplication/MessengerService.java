package com.example.administrator.myapplication;


import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MessengerService extends Service {

    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Toast.makeText(getApplicationContext(), "hello, service", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    Messenger mMessenger = new Messenger(new IncomingHandler());


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "lf++++++:onCreate ");//可以在onCreate中进行初始化的操作。
    }



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(), "binding", Toast.LENGTH_SHORT).show();
        return mMessenger.getBinder();
    }
}
