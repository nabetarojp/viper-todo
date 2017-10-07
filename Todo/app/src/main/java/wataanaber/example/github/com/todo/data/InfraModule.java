package wataanaber.example.github.com.todo.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import wataanaber.example.github.com.todo.data.model.OrmaDatabase;
import wataanaber.example.github.com.todo.data.repository.todo.TodoLocalDataSource;

/**
 * Created by watanabe on 2017/10/02.
 */

@Singleton
@Module
public class InfraModule {

    @Provides
    @Singleton
    TodoLocalDataSource provideTodoLocalDataSource(OrmaDatabase ormaDatabase) {
        return new TodoLocalDataSource(ormaDatabase);
    }
}
