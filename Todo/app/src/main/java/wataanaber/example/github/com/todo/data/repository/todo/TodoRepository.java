package wataanaber.example.github.com.todo.data.repository.todo;

import java.util.List;

import javax.inject.Inject;

import wataanaber.example.github.com.todo.data.model.Todo;
import wataanaber.example.github.com.todo.data.repository.DataSource;

/**
 * Created by watanabe on 2017/10/02.
 */

public class TodoRepository implements DataSource<Todo> {

    public DataSource<Todo> localDataSource;

    @Inject
    public TodoRepository(TodoLocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }


    @Override
    public void add(Todo item) {

    }

    @Override
    public void add(List<Todo> items) {

    }

    @Override
    public void update(Todo item) {

    }

    @Override
    public void update(List<Todo> items) {

    }

    @Override
    public void remove(Todo item) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public Todo fetch(long id) {
        return null;
    }

    @Override
    public List<Todo> fetchAll() {
        return null;
    }


    @Override
    public boolean hasData() {
        return false;
    }
}
