package com.egga.hudangring;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.Random;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Random rdm = new Random();
        int x = rdm.nextInt(2)+1;
        String uriString = intent.getStringExtra("KEY_TONE_URL");
        switch(x) {
            case 1:
                Toast.makeText(context,
                        "Alarm received!",
                        Toast.LENGTH_LONG).show();

                Intent secIntent = new Intent(context, SecondActivity.class);
                secIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                secIntent.putExtra("SEC_RINGTONE_URI", uriString);
                context.startActivity(secIntent);
                break;
            case 2:

                Toast.makeText(context,
                        "Alarm received!",
                        Toast.LENGTH_LONG).show();

                Intent secIntent2 = new Intent(context, ThreeActivity.class);
                secIntent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                secIntent2.putExtra("SEC_RINGTONE_URI", uriString);
                context.startActivity(secIntent2);
        }
        /*String uriString = intent.getStringExtra("KEY_TONE_URL");

        Toast.makeText(context,
                "Alarm received!",
                Toast.LENGTH_LONG).show();

        Intent secIntent = new Intent(context, ThreeActivity.class);
        secIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        secIntent.putExtra("SEC_RINGTONE_URI", uriString);
        context.startActivity(secIntent);*/


    }

}
