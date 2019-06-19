package com.yundongjia.mucai.utils;

import android.util.Log;

import com.yundongjia.mucai.BuildConfig;

public class L {

    private static final String TAG = "mucai";

    private static boolean sDebug = BuildConfig.DEBUG;

    public static void d(String msg,Object... args){
        if(!sDebug){
            return;
        }
        Log.d(TAG, String.format(msg,args));
    }

}
