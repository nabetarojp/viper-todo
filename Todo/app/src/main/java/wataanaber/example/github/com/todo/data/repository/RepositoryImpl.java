package wataanaber.example.github.com.todo.data.repository;

import javax.inject.Inject;

import wataanaber.example.github.com.todo.data.repository.todo.LocalTodoDataSource;

/**
 * Created by watanabe on 2017/10/08.
 */

public class RepositoryImpl implements Repository{

    public LocalTodoDataSource localTodoDataSource;

    @Inject
    public RepositoryImpl(LocalTodoDataSource localTodoDataSource) {
        this.localTodoDataSource = localTodoDataSource;
    }

    @Override
    public LocalTodoDataSource localTodoData() {
        return localTodoDataSource;
    }
}
