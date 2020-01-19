package com.example.myautomation;

import android.app.Service;
import android.content.Intent;
//import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
//import android.provider.Settings;
import android.telephony.SmsManager;
//import android.support.annotation;
import androidx.annotation.Nullable;

/**
 * Created by Belal on 12/30/2016.
 */

public class MyService extends Service {
    //creating a mediaplayer object
    //private MediaPlayer player;
    private int value = 5;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sendSMS();
            handler.postDelayed(this, 1000);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //getting systems default ringtone
        //player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        //setting loop play to true
        //this will make the ringtone continuously playing

        //player.setLooping(true);

        //staring the player
        //player.start();
        if(value >= 10){
        handler.postDelayed(runnable, 1000);}
        //we have some options for service
        //start sticky means service will be explicity started and stopped
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //stopping the player when service is destroyed
        //player.stop();
    }
    public void sendSMS()
    {
        SmsManager sm = SmsManager.getDefault();
        //String number = eTextMblNumber.getText().toString();
        //String msg = eTextMsg.getText().toString();
        sm.sendTextMessage("9487813680", null, "Hi Nitin", null, null);
    }
}