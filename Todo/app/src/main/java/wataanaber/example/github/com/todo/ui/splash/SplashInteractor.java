package wataanaber.example.github.com.todo.ui.splash;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import wataanaber.example.github.com.todo.data.model.OrmaDatabase;


public class SplashInteractor implements SplashContract.Interactor {

    private SplashContract.InteractorOutput out;
    private Disposable disposables = Disposables.empty();

    @Inject
    public SplashInteractor(OrmaDatabase orma) {
        // add dependencies
    }

    @Override
    public void startInteraction(SplashContract.InteractorOutput out) {
        this.out = out;
    }

    @Override
    public void stopInteraction(SplashContract.InteractorOutput out) {
        this.disposables.dispose();
        this.out = null;
    }
}
