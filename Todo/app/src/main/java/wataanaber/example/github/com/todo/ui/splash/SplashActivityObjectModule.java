package wataanaber.example.github.com.todo.ui.splash;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;


@Module
public class SplashActivityObjectModule {

    private SplashContract.View view;

    public SplashActivityObjectModule(SplashContract.View view) {
        this.view = view;
    }

    @Provides
    public SplashContract.Presenter providePresenter(SplashInteractor interactor, SplashRouter router) {
        return new SplashPresenter((Activity) view, view, interactor, router);
    }
}
