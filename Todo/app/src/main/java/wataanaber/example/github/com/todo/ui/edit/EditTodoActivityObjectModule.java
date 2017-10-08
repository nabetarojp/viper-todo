package wataanaber.example.github.com.todo.ui.edit;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;


@Module
public class EditTodoActivityObjectModule {

    private EditTodoContract.View view;

    public EditTodoActivityObjectModule(EditTodoContract.View view) {
        this.view = view;
    }

    @Provides
    public EditTodoContract.Presenter providePresenter(EditTodoInteractor interactor, EditTodoRouter router) {
        return new EditTodoPresenter((Activity) view, view, interactor, router);
    }
}
