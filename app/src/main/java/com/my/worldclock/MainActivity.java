package com.my.worldclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private TextView Sydney;
    private TextView Beijing;
    private TextView NewYork;
    private TextView Tokyo;
    private TextView San;
    private TextView Paris;
    private TextView hr12;
    private TextView hr24;
    private String flag="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            view();
            event();
        mHandler.postDelayed(runnable, 1000);
    }


    private void event() {
        hr12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag="0";
                hr12.setBackgroundResource(R.drawable.btn_bg);
                hr12.setTextColor(getResources().getColor(R.color.white));
                hr24.setBackgroundResource(R.drawable.btn_bg_no);
                hr24.setTextColor(getResources().getColor(R.color.colorPrimary));
                getWorldTime();
            }
        });

        hr24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag="1";
                hr24.setBackgroundResource(R.drawable.btn_bg);
                hr24.setTextColor(getResources().getColor(R.color.white));
                hr12.setBackgroundResource(R.drawable.btn_bg_no);
                hr12.setTextColor(getResources().getColor(R.color.colorPrimary));
                getWorldTime();
            }
        });
    }

    Handler mHandler = new Handler();
    Runnable runnable = new Runnable(){
        @Override
        public void run(){
            getWorldTime();
            mHandler.postDelayed(runnable, 1000);
        }
    };



    private void getWorldTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf;
        if (flag.equals("0")){
            sdf = new SimpleDateFormat("hh:mm:ss");

        }else {
            sdf = new SimpleDateFormat("HH:mm:ss");
        }
        sdf.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
        Sydney.setText(sdf.format(calendar.getTime()));

        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Beijing.setText(sdf.format(calendar.getTime()));


        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        NewYork.setText(sdf.format(calendar.getTime()));

        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        Tokyo.setText(sdf.format(calendar.getTime()));

        sdf.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        San.setText(sdf.format(calendar.getTime()));

        sdf.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        Paris.setText(sdf.format(calendar.getTime()));
    }

    private void view() {
        Sydney=findViewById(R.id.syd);
        Beijing=findViewById(R.id.bj);
        NewYork=findViewById(R.id.ny);
        Tokyo=findViewById(R.id.ty);
        San=findViewById(R.id.san);
        Paris=findViewById(R.id.paris);
        hr12=findViewById(R.id.hr_12);
        hr24=findViewById(R.id.hr_24);
    }
}
