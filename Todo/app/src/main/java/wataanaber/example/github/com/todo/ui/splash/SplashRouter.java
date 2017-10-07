package wataanaber.example.github.com.todo.ui.splash;

import android.app.Activity;

import javax.inject.Inject;

import wataanaber.example.github.com.todo.ui.list.TodoListActivity;


public class SplashRouter implements SplashContract.Router {

    @Inject
    public SplashRouter() {
    }

    @Override
    public void openTodoList(Activity activity) {
        activity.startActivity(TodoListActivity.createIntent(activity));
    }

    // add routing functions
}
