package com.egga.hudangring;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.widget.Toast.makeText;

public class SecondActivity extends AppCompatActivity {
    TextView secInfo;
    Button btnStop1;
    //btnStop2,btnStop3;
    //Button[]all;
    Ringtone ringTone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        secInfo = (TextView) findViewById(R.id.secinfo);
        btnStop1 = (Button) findViewById(R.id.stop1);
        /*btnStop2 = (Button) findViewById(R.id.stop2);
        btnStop3 = (Button) findViewById(R.id.stop3);*/


        String stringUri = getIntent().getStringExtra("SEC_RINGTONE_URI");
        Uri uri = Uri.parse(stringUri);
        secInfo.setText("Stop !!!");

        ringTone = RingtoneManager
                .getRingtone(getApplicationContext(), uri);

        //secInfo.append(ringTone.getTitle(SecondActivity.this));

        ringTone.play();

        /*Random rdm = new Random();
        int x = rdm.nextInt(6)+1;
        switch(x){
            case 1 :
                btnStop1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ringTone != null) {
                            ringTone.stop();
                            ringTone = null;

                            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                });
                break;
        }*/


        btnStop1.setOnClickListener(new View.OnClickListener() {

                @Override
            public void onClick(View view) {
                 if (ringTone != null) {
                      ringTone.stop();
                      ringTone = null;


                      Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                     intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                     intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                     //finish();
                     startActivity(intent);
                 }
            }


        });

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                + WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                +WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                +WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
    }

}
