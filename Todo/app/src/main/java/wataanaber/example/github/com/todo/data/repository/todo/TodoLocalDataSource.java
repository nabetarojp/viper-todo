package wataanaber.example.github.com.todo.data.repository.todo;

import java.util.List;

import javax.inject.Inject;

import wataanaber.example.github.com.todo.data.model.OrmaDatabase;
import wataanaber.example.github.com.todo.data.model.Todo;
import wataanaber.example.github.com.todo.data.repository.DataSource;

/**
 * Created by watanabe on 2017/10/02.
 */

public class TodoLocalDataSource implements DataSource<Todo> {

    private OrmaDatabase ormaDatabase;

    @Inject
    public TodoLocalDataSource(OrmaDatabase ormaDatabase) {
        this.ormaDatabase = ormaDatabase;
    }

    @Override
    public void add(Todo item) {
        ormaDatabase.insertIntoTodo(item);
    }

    @Override
    public void add(List<Todo> items) {
        ormaDatabase.insertIntoTodo(items)
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
