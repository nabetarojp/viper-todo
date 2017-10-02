package wataanaber.example.github.com.todo.ui.splash;


import android.app.Activity;

import javax.inject.Inject;

public class SplashPresenter implements SplashContract.Presenter, SplashContract.InteractorOutput {

    private SplashViewModel viewModel = new SplashViewModel();

    private Activity activity;
    private SplashContract.View view;
    private SplashContract.Interactor interactor;
    private SplashContract.Router router;

    @Inject
    public SplashPresenter(Activity activity,
                           SplashContract.View view,
                           SplashContract.Interactor interactor,
                           SplashContract.Router router) {
        this.activity = activity;
        this.view = view;
        this.interactor = interactor;
        this.router = router;
    }


    @Override
    public void onResume() {
        interactor.startInteraction(this);
    }

    @Override
    public void onPause() {
        interactor.stopInteraction(this);
    }

    @Override
    public void onError(Throwable t) {
        view.showError(t.getMessage() != null ? t.getMessage() : "error");
    }
}
