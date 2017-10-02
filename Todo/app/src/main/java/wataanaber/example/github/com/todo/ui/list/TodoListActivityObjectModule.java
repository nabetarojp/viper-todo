package wataanaber.example.github.com.todo.ui.list;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;


@Module
public class TodoListActivityObjectModule {

    private TodoListContract.View view;

    public TodoListActivityObjectModule(TodoListContract.View view) {
        this.view = view;
    }

    @Provides
    public TodoListContract.Presenter providePresenter(TodoListInteractor interactor, TodoListRouter router) {
        return new TodoListPresenter((Activity) view, view, interactor, router);
    }
}
