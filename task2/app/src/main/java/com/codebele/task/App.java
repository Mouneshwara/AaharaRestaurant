package com.codebele.task;

import android.app.Application;
import android.content.Context;

import com.codebele.task.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class App extends Application implements HasAndroidInjector {
    public static Context appContext;

    private static com.codebele.task.App instance;

    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
        instance=this;
    }

    public static synchronized com.codebele.task.App getInstance() {
        return instance;
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }
}

