package wataanaber.example.github.com.todo.ui.list;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {TodoListActivityObjectModule.class})
public interface TodoListActivityComponent extends AndroidInjector<TodoListActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TodoListActivity> {
        public abstract void objectModule(TodoListActivityObjectModule objectModule);

        @Override
        public void seedInstance(TodoListActivity instance) {
            objectModule(new TodoListActivityObjectModule(instance));
        }
    }
}
