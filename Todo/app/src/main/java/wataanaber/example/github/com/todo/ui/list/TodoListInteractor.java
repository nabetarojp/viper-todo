package wataanaber.example.github.com.todo.ui.list;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;
import wataanaber.example.github.com.todo.data.repository.Repository;


public class TodoListInteractor implements TodoListContract.Interactor {

    private TodoListContract.InteractorOutput out;
    private Disposable disposables = Disposables.empty();

    private Repository repository;

    @Inject
    public TodoListInteractor(Repository repository) {
        // add dependencies
        this.repository = repository;
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

    @Override
    public void fetchTodos() {
        if (!repository.localTodoData().isEmpty()) {
            disposables = repository.localTodoData().fetchAllAsSingle()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(todos -> out.onFetchTodo(true, todos));
        } else {
            out.onFetchTodo(false, null);
        }
    }
}
