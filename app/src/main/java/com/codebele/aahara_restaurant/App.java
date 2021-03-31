package com.codebele.aahara_restaurant;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;


import androidx.annotation.RequiresApi;

import com.codebele.aahara_restaurant.networkUtils.ConnectivityReceiver;

public class App extends Application  {
    public    static App pInstance;

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate() {
        super.onCreate();
        pInstance=this;
        super.onCreate();
        getScreenSize();

    }

    public static synchronized App getpInstance(){
        return pInstance;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void getScreenSize() {
        WindowManager windowManager = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if(SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }
//   // public static synchronized MyApplication getInstance() {
//        return mInstance;
//    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}

