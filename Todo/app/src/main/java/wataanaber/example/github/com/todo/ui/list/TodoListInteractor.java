package wataanaber.example.github.com.todo.ui.list;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;


public class TodoListInteractor implements TodoListContract.Interactor {

    private TodoListContract.InteractorOutput out;
    private Disposable disposables = Disposables.empty();

    @Inject
    public TodoListInteractor() {
        // add dependencies
    }

    @Override
    public void startInteraction(TodoListContract.InteractorOutput out) {
        this.out = out;
    }

    @Override
    public void stopInteraction(TodoListContract.InteractorOutput out) {
        this.disposables.dispose();
        this.out = null;
    }
}
