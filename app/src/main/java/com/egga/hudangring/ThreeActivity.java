package com.egga.hudangring;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

import static android.app.PendingIntent.getActivity;


public class ThreeActivity extends AppCompatActivity {
    Ringtone ringTone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_2);
        /*btnStop2 = (Button) findViewById(R.id.stop2);
        btnStop3 = (Button) findViewById(R.id.stop3);*/


        String stringUri = getIntent().getStringExtra("SEC_RINGTONE_URI");
        Uri uri = Uri.parse(stringUri);

        ringTone = RingtoneManager
                .getRingtone(getApplicationContext(), uri);

        //secInfo.append(ringTone.getTitle(SecondActivity.this));

        ringTone.play();



        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                + WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                +WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                +WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
    }

    public void buttonProses(View view) {

        EditText etA = (EditText) findViewById(R.id.editText);

        float bilanganA = Float.valueOf(etA.getText().toString());

        if (bilanganA == 20) {
            showBenar();
            if (ringTone != null) {
                ringTone.stop();
                ringTone = null;


                Intent intent = new Intent(ThreeActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //finish();
                startActivity(intent);
            }
        }
        else {
            showSalah();

        }
    }

    private void showBenar() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Benar.........");
        // set pesan dari dialog
        AlertDialog
                .Builder ok = alertDialogBuilder
                //.setMessage("Lanjutkan ......")
                .setIcon(R.drawable.uc_ico)
                .setCancelable(false)
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ThreeActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }

    private void showSalah() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Salah");
        // set pesan dari dialog
        AlertDialog
                .Builder ok = alertDialogBuilder
                .setMessage("")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setNeutralButton("Kembali", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        // do something
                        dialog.cancel();
                    }
                });
        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }

}

