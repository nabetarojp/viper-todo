package wataanaber.example.github.com.todo.data.repository;

import javax.inject.Inject;

import wataanaber.example.github.com.todo.data.repository.todo.TodoLocalDataSource;

/**
 * Created by watanabe on 2017/10/08.
 */

public class Repository {

    public TodoLocalDataSource todoLocalDataSource;

    @Inject
    public Repository(TodoLocalDataSource todoLocalDataSource) {
        this.todoLocalDataSource = todoLocalDataSource;
    }
}
