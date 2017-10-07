package wataanaber.example.github.com.todo.ui.create;


import android.app.Activity;

import javax.inject.Inject;

import wataanaber.example.github.com.todo.data.model.Todo;

public class CreateTodoPresenter implements CreateTodoContract.Presenter, CreateTodoContract.InteractorOutput {

    private CreateTodoViewModel viewModel = new CreateTodoViewModel();

    private Activity activity;
    private CreateTodoContract.View view;
    private CreateTodoContract.Interactor interactor;
    private CreateTodoContract.Router router;

    @Inject
    public CreateTodoPresenter(Activity activity,
                               CreateTodoContract.View view,
                               CreateTodoContract.Interactor interactor,
                               CreateTodoContract.Router router) {
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
    public void saveTodo(String title, String content) {
        Todo t = new Todo();
        t.title = title;
        t.content = content;
        interactor.saveTodo(t);
    }

    @Override
    public void onSave() {
        router.backToParent(activity);
    }

    @Override
    public void onError(Throwable t) {
        view.showError(t.getMessage() != null ? t.getMessage() : "error");
    }
}
