package wataanaber.example.github.com.todo.ui.create;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {CreateTodoActivityObjectModule.class})
public interface CreateTodoActivityComponent extends AndroidInjector<CreateTodoActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CreateTodoActivity> {
        public abstract void objectModule(CreateTodoActivityObjectModule objectModule);

        @Override
        public void seedInstance(CreateTodoActivity instance) {
            objectModule(new CreateTodoActivityObjectModule(instance));
        }
    }
}
