package wataanaber.example.github.com.todo.ui.splash;


import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SplashActivityComponent.class})
public abstract class SplashActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(SplashActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindSplashActivityInjectorFactory(SplashActivityComponent.Builder builder);
}
