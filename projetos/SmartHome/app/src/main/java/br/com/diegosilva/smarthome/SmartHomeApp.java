package br.com.diegosilva.smarthome;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * Created by 98379720172 on 10/06/2016.
 */
public class SmartHomeApp extends Application{

    private static SmartHomeApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getAppContext() {
        return instance.getApplicationContext();
    }

    public static Application getInstance() {
        return instance;
    }

    public static Resources getAppResources() {
        return getInstance().getResources();
    }

}
