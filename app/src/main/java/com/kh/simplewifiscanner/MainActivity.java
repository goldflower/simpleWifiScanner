package com.kh.simplewifiscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {
    private Handler mSteadyCheckHandler = new Handler();
    private WifiScanner scanner;
    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.activity = this;
        if(checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
        scanner = new WifiScanner(this);
    }

    @Override
    public void onResume(){
        super.onResume();
        mSteadyCheckHandler.postDelayed(mScanHandlerTask, 1000);
    }

    Runnable mScanHandlerTask = new Runnable()
    {
        @Override
        public void run() {
            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            }
            scanner.getWifiScanResults();
            mSteadyCheckHandler.postDelayed(mScanHandlerTask, 1000);
        }
    };
}
