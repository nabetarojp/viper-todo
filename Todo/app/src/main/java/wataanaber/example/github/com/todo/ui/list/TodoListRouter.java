package wataanaber.example.github.com.todo.ui.list;

import android.app.Activity;

import javax.inject.Inject;

import wataanaber.example.github.com.todo.ui.create.CreateTodoActivity;


public class TodoListRouter implements TodoListContract.Router {

    @Inject
    public TodoListRouter() {
    }

    @Override
    public void openCreateTodo(Activity activity) {
        activity.startActivity(CreateTodoActivity.createIntent(activity));
    }

    @Override
    public void openEditTodo(Activity activity) {
        // TODO: 2017/10/07
    }

    // add routing functions
}
