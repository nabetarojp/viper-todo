package wataanaber.example.github.com.todo.ui.create;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import wataanaber.example.github.com.todo.data.model.Todo;
import wataanaber.example.github.com.todo.data.repository.Repository;


public class CreateTodoInteractor implements CreateTodoContract.Interactor {

    private CreateTodoContract.InteractorOutput out;
    private Disposable disposables = Disposables.empty();

    private Repository repository;

    @Inject
    public CreateTodoInteractor(Repository repository) {
        this.repository = repository;
        // add dependencies
    }

    @Override
    public void startInteraction(CreateTodoContract.InteractorOutput out) {
        this.out = out;
    }

    @Override
    public void stopInteraction(CreateTodoContract.InteractorOutput out) {
        this.disposables.dispose();
        this.out = null;
    }

    @Override
    public void saveTodo(Todo todo) {
        repository.localTodoData().add(todo);
        out.onSave();
    }
}
