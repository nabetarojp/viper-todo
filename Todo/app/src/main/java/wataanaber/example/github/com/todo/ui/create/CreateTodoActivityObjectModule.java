package wataanaber.example.github.com.todo.ui.create;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;


@Module
public class CreateTodoActivityObjectModule {

    private CreateTodoContract.View view;

    public CreateTodoActivityObjectModule(CreateTodoContract.View view) {
        this.view = view;
    }

    @Provides
    public CreateTodoContract.Presenter providePresenter(CreateTodoInteractor interactor, CreateTodoRouter router) {
        return new CreateTodoPresenter((Activity) view, view, interactor, router);
    }
}
