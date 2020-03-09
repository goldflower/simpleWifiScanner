package com.kh.simplewifiscanner;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.util.List;


public class WifiScanner {
    private List<ScanResult> mWifiScanResult;
    private WifiManager mWifiManager;
    private Context context;
    public WifiScanner(Context context){
        this.context = context;
        mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

     public void getWifiScanResults(){
        if(!mWifiManager.isWifiEnabled()){
            mWifiManager.setWifiEnabled(true);
        }
        mWifiScanResult = mWifiManager.getScanResults();
        for (int i = 0; i < mWifiScanResult.size(); i++) {
            Log.d("Wifi", mWifiScanResult.get(i)+"");
        }
    }
}
