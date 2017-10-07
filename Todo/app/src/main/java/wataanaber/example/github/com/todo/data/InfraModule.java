package wataanaber.example.github.com.todo.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import wataanaber.example.github.com.todo.data.model.OrmaDatabase;
import wataanaber.example.github.com.todo.data.repository.Repository;
import wataanaber.example.github.com.todo.data.repository.RepositoryImpl;
import wataanaber.example.github.com.todo.data.repository.todo.LocalTodoDataSource;

/**
 * Created by watanabe on 2017/10/02.
 */

@Singleton
@Module
public class InfraModule {

    @Provides
    @Singleton
    Repository provideRepository(LocalTodoDataSource localTodoDataSource) {
        return new RepositoryImpl(localTodoDataSource);
    }

    @Provides
    @Singleton
    LocalTodoDataSource provideTodoLocalDataSource(OrmaDatabase ormaDatabase) {
        return new LocalTodoDataSource(ormaDatabase);
    }
}
