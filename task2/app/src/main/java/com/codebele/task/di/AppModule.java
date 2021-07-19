package com.codebele.task.di;

import android.content.Context;


import com.codebele.task.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mounesh on 17-7-21.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideApplicationContent(App app) {
        return app.getApplicationContext();
    }

   /* @Provides
    @Singleton
    ApiErrorHandler provideApiErrorHandler() {
        return new ApiErrorHandler();
    }


    @Provides
    @Singleton
    LoginSessionManager providePreferenceManager(Context context) {
        return new LoginSessionManager(context);
    }*/
}
