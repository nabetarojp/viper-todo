package wataanaber.example.github.com.todo.ui.create;

import android.app.Activity;

import wataanaber.example.github.com.todo.data.model.Todo;

public interface CreateTodoContract {

    interface View {
        void showError(String message);
    }

    interface Presenter {
        void onResume(); // base
        void onPause(); // base
        void saveTodo(String title, String content);
    }

    interface Interactor {
        void startInteraction(InteractorOutput out); // base
        void stopInteraction(InteractorOutput out); // base

        void saveTodo(Todo todo);
    }

    interface InteractorOutput {
        void onSave();
        void onError(Throwable t);
    }

    interface Router {
        void backToParent(Activity activity);
    }

}
