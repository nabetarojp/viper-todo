package wataanaber.example.github.com.todo.ui.edit;

public interface EditTodoContract {

    interface View {
        void showError(String message);
    }

    interface Presenter {
        void onResume(); // base

        void onPause(); // base
    }

    interface Interactor {
        void startInteraction(InteractorOutput out); // base

        void stopInteraction(InteractorOutput out); // base
    }

    interface InteractorOutput {
        void onError(Throwable t);
    }

    interface Router {

    }

}
