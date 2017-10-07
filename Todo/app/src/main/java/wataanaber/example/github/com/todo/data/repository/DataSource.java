package wataanaber.example.github.com.todo.data.repository;

import java.util.List;

/**
 * Created by watanabe on 2017/10/02.
 */

public interface DataSource<T> {
    void add(T item);
    void add(List<T> items);
    void update(T item);
    void update(List<T> items);
    void remove(T item);
    boolean hasData();
}
