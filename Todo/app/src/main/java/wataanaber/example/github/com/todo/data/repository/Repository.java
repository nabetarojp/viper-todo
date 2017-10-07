package wataanaber.example.github.com.todo.data.repository;

import wataanaber.example.github.com.todo.data.repository.todo.LocalTodoDataSource;

/**
 * Created by watanabe on 2017/10/08.
 */

public interface Repository {
    LocalTodoDataSource localTodoData();
}
