package wataanaber.example.github.com.todo.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import wataanaber.example.github.com.todo.data.repository.todo.TodoLocalDataSource;
import wataanaber.example.github.com.todo.data.repository.todo.TodoRepository;

/**
 * Created by watanabe on 2017/10/02.
 */

@Singleton
@Module
public class InfraModule {

    @Provides
    @Singleton
    TodoRepository provideTodoRepository(TodoLocalDataSource localDataSource) {
        return new TodoRepository(localDataSource);
    }
}
