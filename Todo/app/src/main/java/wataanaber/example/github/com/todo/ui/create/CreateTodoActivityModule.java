package wataanaber.example.github.com.todo.ui.create;


import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CreateTodoActivityComponent.class})
public abstract class CreateTodoActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(CreateTodoActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindCreateTodoActivityInjectorFactory(CreateTodoActivityComponent.Builder builder);
}
