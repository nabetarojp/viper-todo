package wataanaber.example.github.com.todo.ui.list;


import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {TodoListActivityComponent.class})
public abstract class TodoListActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(TodoListActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindTodoListActivityInjectorFactory(TodoListActivityComponent.Builder builder);
}
