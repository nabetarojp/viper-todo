package wataanaber.example.github.com.todo.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import wataanaber.example.github.com.todo.TodoApp;
import wataanaber.example.github.com.todo.data.InfraModule;
import wataanaber.example.github.com.todo.ui.create.CreateTodoActivityModule;
import wataanaber.example.github.com.todo.ui.list.TodoListActivityModule;
import wataanaber.example.github.com.todo.ui.splash.SplashActivityModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        InfraModule.class,
        SplashActivityModule.class,
        TodoListActivityModule.class,
        CreateTodoActivityModule.class
})
public interface AppComponent {

    public void inject(TodoApp application);

}
