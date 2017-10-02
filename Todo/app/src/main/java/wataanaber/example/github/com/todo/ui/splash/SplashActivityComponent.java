package wataanaber.example.github.com.todo.ui.splash;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {SplashActivityObjectModule.class})
public interface SplashActivityComponent extends AndroidInjector<SplashActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SplashActivity> {
        public abstract void objectModule(SplashActivityObjectModule objectModule);

        @Override
        public void seedInstance(SplashActivity instance) {
            objectModule(new SplashActivityObjectModule(instance));
        }
    }
}
