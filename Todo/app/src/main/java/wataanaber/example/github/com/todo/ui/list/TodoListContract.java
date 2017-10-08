package wataanaber.example.github.com.todo.ui.list;

import android.app.Activity;

import java.util.List;

import wataanaber.example.github.com.todo.data.model.Todo;

public interface TodoListContract {

    interface View {
        void showError(String message);
        void showTodos(List<Todo> todos);
        void showProgressBar();
        void hideProgressBar();
        void showEmpty();
    }

    interface Presenter {
        void onResume(); // base
        void onPause(); // base

        void fetchTodos();

        void openEditTodo(Todo todo);
        void openCreateTodo();
    }

    interface Interactor {
        void startInteraction(InteractorOutput out); // base
        void stopInteraction(InteractorOutput out); // base

        void fetchTodos();
    }

    interface InteractorOutput {
        void onFetchTodo(boolean hasData, List<Todo> todos);
        void onError(Throwable t);
    }

    interface Router {
        void openCreateTodo(Activity activity);
        void openEditTodo(Activity activity);
    }

}
