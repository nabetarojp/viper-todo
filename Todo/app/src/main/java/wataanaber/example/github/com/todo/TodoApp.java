package wataanaber.example.github.com.todo;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasDispatchingActivityInjector;
import wataanaber.example.github.com.todo.data.InfraModule;
import wataanaber.example.github.com.todo.di.AppComponent;
import wataanaber.example.github.com.todo.di.AppModule;
import wataanaber.example.github.com.todo.di.DaggerAppComponent;

/**
 * Created by watanabe on 2017/10/02.
 */

public class TodoApp extends MultiDexApplication implements HasDispatchingActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .infraModule(new InfraModule())
                .build();
        appComponent.inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
