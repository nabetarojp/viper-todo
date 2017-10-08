package wataanaber.example.github.com.todo.ui.edit;


import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {EditTodoActivityComponent.class})
public abstract class EditTodoActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(EditTodoActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindEditTodoActivityInjectorFactory(EditTodoActivityComponent.Builder builder);
}
