package wataanaber.example.github.com.todo.ui.edit;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {EditTodoActivityObjectModule.class})
public interface EditTodoActivityComponent extends AndroidInjector<EditTodoActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<EditTodoActivity> {
        public abstract void objectModule(EditTodoActivityObjectModule objectModule);

        @Override
        public void seedInstance(EditTodoActivity instance) {
            objectModule(new EditTodoActivityObjectModule(instance));
        }
    }
}
