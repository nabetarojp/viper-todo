package wataanaber.example.github.com.todo.ui.edit;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;


public class EditTodoInteractor implements EditTodoContract.Interactor {

    private EditTodoContract.InteractorOutput out;
    private Disposable disposables = Disposables.empty();

    @Inject
    public EditTodoInteractor() {
        // add dependencies
    }

    @Override
    public void startInteraction(EditTodoContract.InteractorOutput out) {
        this.out = out;
    }

    @Override
    public void stopInteraction(EditTodoContract.InteractorOutput out) {
        this.disposables.dispose();
        this.out = null;
    }
}
