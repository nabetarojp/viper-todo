package wataanaber.example.github.com.todo.ui.list;


import android.app.Activity;

import java.util.List;

import javax.inject.Inject;

import wataanaber.example.github.com.todo.data.model.Todo;

public class TodoListPresenter implements TodoListContract.Presenter, TodoListContract.InteractorOutput {

    private TodoListViewModel viewModel = new TodoListViewModel();

    private Activity activity;
    private TodoListContract.View view;
    private TodoListContract.Interactor interactor;
    private TodoListContract.Router router;

    @Inject
    public TodoListPresenter(Activity activity,
                             TodoListContract.View view,
                             TodoListContract.Interactor interactor,
                             TodoListContract.Router router) {
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
    public void fetchTodos() {
        interactor.fetchTodos();
        view.showProgressBar();
    }

    @Override
    public void openEditTodo(Todo todo) {
        router.openEditTodo(activity);
    }

    @Override
    public void openCreateTodo() {
        router.openCreateTodo(activity);
    }

    @Override
    public void onFetchTodo(boolean hasData, List<Todo> todos) {
        if (hasData) {
            view.showTodos(todos);
        } else {
            view.showEmpty();
        }
        view.hideProgressBar();
    }

    @Override
    public void onError(Throwable t) {
        view.showError(t.getMessage() != null ? t.getMessage() : "error");
    }
}
