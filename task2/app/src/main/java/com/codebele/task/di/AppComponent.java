package com.codebele.task.di;





import com.codebele.task.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by mounesh on 17-7-21.
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class,BuilderModule.class})
public interface AppComponent extends AndroidInjector<App> {
    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App application);
        AppComponent build();
    }
}