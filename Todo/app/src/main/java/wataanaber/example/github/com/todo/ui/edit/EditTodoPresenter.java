package wataanaber.example.github.com.todo.ui.edit;


import android.app.Activity;

import javax.inject.Inject;

public class EditTodoPresenter implements EditTodoContract.Presenter, EditTodoContract.InteractorOutput {

    private EditTodoViewModel viewModel = new EditTodoViewModel();

    private Activity activity;
    private EditTodoContract.View view;
    private EditTodoContract.Interactor interactor;
    private EditTodoContract.Router router;

    @Inject
    public EditTodoPresenter(Activity activity,
                             EditTodoContract.View view,
                             EditTodoContract.Interactor interactor,
                             EditTodoContract.Router router) {
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
