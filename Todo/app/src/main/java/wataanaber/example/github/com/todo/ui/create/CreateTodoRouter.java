package wataanaber.example.github.com.todo.ui.create;

import android.app.Activity;

import javax.inject.Inject;


public class CreateTodoRouter implements CreateTodoContract.Router {

    @Inject
    public CreateTodoRouter() {
    }

    @Override
    public void backToParent(Activity activity) {
        activity.finish();
    }

    // add routing functions
}
