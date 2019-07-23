package com.mksoft.a0714userinsertanduserdeleteproject;

import android.app.Activity;
import android.app.Application;
import android.content.Context;


import com.mksoft.a0714userinsertanduserdeleteproject.DI.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


public class App extends Application implements HasActivityInjector {
    public static Context context;
    public static String BASE_URL = "http://192.168.0.5:3000/";//서버 변수
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;


    @Override
    public void onCreate() {
        super.onCreate();
        this.initDagger();
        context = getApplicationContext();

    }



    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }



    private void initDagger(){
        DaggerAppComponent.builder().application(this).build().inject(this);
    }


}
